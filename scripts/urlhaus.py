# urlhaus_br_neutralizado.py
import requests, csv, json
from io import StringIO
from datetime import datetime

URL = "https://urlhaus.abuse.ch/feeds/country/BR/"
HEADERS = [
    "Dateadded (UTC)", "URL", "URL_status", "Threat",
    "Host", "IPaddress", "ASnumber", "Country"
]

def neut_url(s: str) -> str:
    if not s: return s
    s = s.replace("http://", "http://").replace("https://", "https://")
    s = s.replace(".", "[.]")
    return s

def neut_ip(s: str) -> str:
    if not s: return s
    return s.replace(".", "[.]")

def fetch_and_parse(url=URL):
    resp = requests.get(url, timeout=60)
    resp.raise_for_status()

    # só as linhas de dados (começam com aspas)
    data_lines = [ln for ln in resp.text.splitlines() if ln.startswith('"')]
    reader = csv.DictReader(
        StringIO("\n".join(data_lines)),
        fieldnames=HEADERS, delimiter=",", quotechar='"'
    )

    entries = []
    for row in reader:
        # data
        dt = row.get("Dateadded (UTC)")
        try:
            dt = datetime.strptime(dt, "%Y-%m-%d %H:%M:%S")
        except Exception:
            pass

        entries.append({
            "date_added_utc": dt if isinstance(dt, datetime) else str(dt),
            "url": neut_url(row.get("URL")),
            "status": row.get("URL_status"),
            "threat": row.get("Threat"),
            "host": neut_url(row.get("Host")),   # neutraliza domínio/host
            "ip": neut_ip(row.get("IPaddress")), # neutraliza IP
            "asn": row.get("ASnumber"),
            "country": row.get("Country"),
        })
    return entries

if __name__ == "__main__":
    data = fetch_and_parse()
    print("Total registros:", len(data))

    # salva em JSONL seguro (1 objeto por linha)
    out_path = "urlhaus_BR.jsonl.safe"
    with open(out_path, "w", encoding="utf-8", newline="\n") as f:
        for obj in data:
            json.dump(obj, f, ensure_ascii=False, default=str)
            f.write("\n")
    print(f"Arquivo salvo: {out_path}")

    # mostra amostra
    for r in data[:2]:
        print(r)
