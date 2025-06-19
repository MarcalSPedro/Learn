const express = require('express');
const router = express.Router();
const Produto = require('../models/Produto');

// rotas filhos

router.patch('/atualizar', async (req, res) => {
    console.log("atualizando!")
    res.json("ok")
})

// GET: Listar todos os produtos
router.get('/', async (req, res) => {
  console.log('[GET] /produtos - Buscando todos os produtos');

  const produtos = await Produto.find();
  res.json(produtos);
});

// GET: Buscar produto por ID
router.get('/:id', async (req, res) => {
  const { id } = req.params;
  console.log(`[GET] /produtos/${id} - Buscando produto por ID`);
  try {
    const produto = await Produto.findById(id);
    if (produto) {
      res.json(produto);
    } else {
      console.log(`[GET] Produto com ID ${id} não encontrado`);
      res.status(404).json({ message: 'Produto não encontrado' });
    }
  } catch (err) {
    console.error(`[GET] Erro ao buscar produto por ID: ${err.message}`);
    res.status(500).json({ message: 'Erro ao buscar produto' });
  }
});

// GET: Buscar produto por nome
router.get('/nome/:nome', async (req, res) => {
  const { nome } = req.params;
  console.log(`[GET] /produtos/nome/${nome} - Buscando produto por nome`);
  try {
    const produto = await Produto.findOne({ nome });
    if (produto) {
      res.json(produto);
    } else {
      console.log(`[GET] Produto com nome "${nome}" não encontrado`);
      res.status(404).json({ message: 'Produto não encontrado' });
    }
  } catch (err) {
    console.error(`[GET] Erro ao buscar produto por nome: ${err.message}`);
    res.status(500).json({ message: 'Erro ao buscar produto' });
  }
});

// POST: Cadastrar novo produto
router.post('/', async (req, res) => {
  console.log('[POST] /produtos - Cadastrando novo produto', req.body);
  try {
    const novoProduto = new Produto(req.body);
    const salvo = await novoProduto.save();
    console.log(`[POST] Produto cadastrado com ID ${salvo._id}`);
    res.status(201).json(salvo);
  } catch (err) {
    console.error(`[POST] Erro ao cadastrar produto: ${err.message}`);
    res.status(400).json({ message: 'Erro ao cadastrar produto' });
  }
});

// PUT: Atualizar produto por ID
router.put('/:id', async (req, res) => {
  const { id } = req.params;
  console.log(`[PUT] /produtos/${id} - Atualizando produto`, req.body);
  try {
    const atualizado = await Produto.findByIdAndUpdate(id, req.body, { new: true });
    if (atualizado) {
      console.log(`[PUT] Produto com ID ${id} atualizado`);
      res.json(atualizado);
    } else {
      console.log(`[PUT] Produto com ID ${id} não encontrado`);
      res.status(404).json({ message: 'Produto não encontrado' });
    }
  } catch (err) {
    console.error(`[PUT] Erro ao atualizar produto: ${err.message}`);
    res.status(500).json({ message: 'Erro ao atualizar produto' });
  }
});

// DELETE: Remover produto por ID
router.delete('/:id', async (req, res) => {
  const { id } = req.params;
  console.log(`[DELETE] /produtos/${id} - Removendo produto`);
  try {
    const deletado = await Produto.findByIdAndDelete(id);
    if (deletado) {
      console.log(`[DELETE] Produto com ID ${id} deletado`);
      res.status(204).end();
    } else {
      console.log(`[DELETE] Produto com ID ${id} não encontrado`);
      res.status(404).json({ message: 'Produto não encontrado' });
    }
  } catch (err) {
    console.error(`[DELETE] Erro ao deletar produto: ${err.message}`);
    res.status(500).json({ message: 'Erro ao deletar produto' });
  }
});

module.exports = router;
