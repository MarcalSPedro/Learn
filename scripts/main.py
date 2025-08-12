

# agregador.py
import csv, io, re, requests, pandas as pd
from urllib.parse import urlparse

OPENPHISH_TXT = "https://openphish.com/feed.txt"
PHISHTANK_CSV = "http://data.phishtank.com/data/online-valid.csv"   # requer API key se rate-limit
URLHAUS_BR_JSON = "https://urlhaus.abuse.ch/feeds/country/BR/"      # use 'Generate JSON' na página

def domain(u):
    try:
        h = urlparse(u).hostname or ""
        return h.lower().lstrip("www.")
    except Exception:
        return ""

# OpenPhish
op = requests.get(OPENPHISH_TXT, timeout=60).text.splitlines()
df_op = pd.DataFrame({"url":[u.strip() for u in op if u.strip()]}).assign(source="openphish")

# PhishTank
pt = requests.get(PHISHTANK_CSV, timeout=60).content
df_pt = pd.read_csv(io.BytesIO(pt)).rename(columns={"url":"url"}); df_pt["source"]="phishtank"
df_pt = df_pt[df_pt["online"].astype(str).str.lower()=="true"][["url","source"]]

# URLhaus Brasil
# Dica: na página de feeds clique em "Generate JSON" para CC=BR e use a URL gerada aqui
uh = requests.get(URLHAUS_BR_JSON, timeout=60).json()
df_uh = pd.DataFrame(uh.get("urls", []))
df_uh = df_uh.rename(columns={"url":"url"})[["url"]]; df_uh["source"]="urlhaus_br"

# Merge
df = pd.concat([df_op, df_pt, df_uh], ignore_index=True)
df["domain"] = df["url"].map(domain)

# Filtro adicional: .br ou feed BR
df = df[(df["domain"].str.endswith(".br")) | (df["source"]=="urlhaus_br")]

# Dedup
df = df.drop_duplicates(subset=["url"]).reset_index(drop=True)

# Salva
df.to_csv("fraudes_br.csv", index=False)
print("Total URLs BR:", len(df))