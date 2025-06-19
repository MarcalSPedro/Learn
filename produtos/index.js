// este arquivo é meu start de projeto
// as dependencias que eu importo para rodar este projeto

const express = require('express'); // server http - ele é quem vai abrir o servidor para que o cliente possa acessar as rotas
const mongoose = require('mongoose'); // driver de conexão do node para o banco db mongo
const produtoRoutes = require('./routes/produtos'); // importar as rotas e suas services
const swaggerUi = require('swagger-ui-express'); // swagger
const swaggerDocument = require('./swagger.json'); // swaggerDocs
const app = express();

require('dotenv').config();

app.use(express.json());
app.use('/api-docs', swaggerUi.serve, swaggerUi.setup(swaggerDocument)); // isto é uma roda registrada
app.use('/produtos', produtoRoutes); // rota pai /produtos e dentro dela eu posso passar outras rotas menores para adicionar a fila de criação

const PORT = process.env.PORT || 3000; // porta para rodar o servidor

// conexão com o meu banco de dados mongo db
// process é um comando nativo do node js para buscar variaveis de ambiente locais
mongoose.connect(process.env.MONGO_URI, { useNewUrlParser: true, useUnifiedTopology: true })
  .then(() => {
    console.log('MongoDB conectado');
    app.listen(PORT, () => console.log(`Servidor rodando na porta ${PORT}`));
  })
  .catch(err => console.error(err));

