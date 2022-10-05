const express = require('express')
const app = express()
const port = 8080

app.set('view engine', 'ejs');
app.set('views', './views');

app.use(express.static('public'));
app.use(express.json())
app.use(express.urlencoded({ extended: true }))

var produtos = [{
  id: 1,
  nome: 'Fusca',
  preco: 20000
}];
var produto_id = 2;

app.post('/mirror', function (req, res, next) {
  console.log(req.body)
  res.send(req.body)
})

// app.get('/', (req, res) => {
//   res.send('<h1>Web - Aula Git</h1>')
// })

app.get('/querytojson', (req, res) => {
  console.log(req.query);
  res.send(req.query);
})

app.get('/home', (req, res) => {
  res.render('home', {title: 'Lab MPA', message: 'Bem vindo ao Lab MPA', condicao: false});
});

app.get('/produto/listar', (req, res) => {
  res.render('produto/listar', {produtos: produtos});
});

app.get('/produto/cadastrar', (req, res) => {
  res.render('produto/cadastrar');
});

app.post('/produto/cadastrar', (req, res) => {
  console.log('POST - produto/cadastrar - body: ' + req.body);
  let produto = req.body;
  if(req.body){
    produto.id = produto_id++;
    produtos.push(produto);
  }
  // res.render('produto/cadastrar-confirm', {produto: produto});
  res.redirect('/produto/listar')
});

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})
