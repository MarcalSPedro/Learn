const mongoose = require('mongoose');
// models é aquela entidade que vai representar o banco

const produtoSchema = new mongoose.Schema({ // tipo class
  nome: { type: String, required: true },
  descricao: String,
  cor: String,
  peso: Number,
  tipo: String,
  preco: Number,
  dataCadastro: { type: Date, default: Date.now }
});

module.exports = mongoose.model('Produto', produtoSchema);