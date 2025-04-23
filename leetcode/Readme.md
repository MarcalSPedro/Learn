leetcode-go/
│
├── cmd/                  # Contém os pontos de entrada da aplicação (executáveis)
│   └── leetcode/         # O ponto de entrada principal da aplicação
│       └── main.go       # Função main, que orquestra a execução do programa
│
├── pkg/                  # Contém pacotes reutilizáveis (funcionalidades principais)
│   ├── array/            # Soluções relacionadas a Arrays
│   ├── string/           # Soluções relacionadas a Strings
│   ├── dynamicprogramming/ # Soluções de Programação Dinâmica
│   ├── graph/            # Soluções de Grafos
│   ├── tree/             # Soluções de Árvores
│   ├── search/           # Algoritmos de Busca (Binária, DFS, BFS)
│   ├── linkedlist/       # Soluções de Listas Ligadas
│   └── sorting/          # Soluções de Algoritmos de Ordenação
│
├── internal/             # Contém pacotes internos, exclusivos para o projeto
│   ├── util/             # Funções auxiliares e utilitárias (como testes, validação)
│   └── constants/        # Constantes globais, se necessário
│
├── test/                 # Contém testes para cada solução
│   ├── array_test.go     # Testes para problemas relacionados a arrays
│   ├── string_test.go    # Testes para problemas relacionados a strings
│   └── ...               # Testes para outros pacotes
│
├── go.mod                # Go modules para gerenciamento de dependências
└── README.md             # Documentação do projeto
