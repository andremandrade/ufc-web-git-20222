const express = require('express')
const basicAuth = require('express-basic-auth')
const app = express()
const port = 3000

app.set('view engine', 'ejs');
app.set('views', './views');

app.use(express.static('public'));
app.use(express.json())
app.use(express.urlencoded({ extended: true }))

const mongoRepository = require('./repository/mongo-repository')

app.use((req, res, next) => {
  console.log('meu middleware')
  next();
})

app.use(basicAuth({
  authorizer: userAuthorizer,
  challenge: true,
  authorizeAsync: true
}));

function userAuthorizer(username, password, callback){
  console.log('=== UserAuthorizer Middleware');
  console.log('Username: ' + username)
  console.log('Password: ' + password)

  mongoRepository.getUsers(username, password).then(users => {
    console.log(users);
    callback(null, users.length == 0 ? false : true);
  });
}

app.use((req, res, next) => {
  console.log('=== User Session Middleware');
  basic = Buffer.from(req.headers.authorization.split(' ')[1], 'base64').toString().split(':');
  username = basic[0];
  password = basic[1];
  mongoRepository.getUsers(username, password).then(users => {
    loggedUser = users[0];
    console.log(loggedUser);
    req.user = loggedUser;
    next()
  });
})

app.get('/home',(req,res) => {
    console.log('=== GET -/home');
    console.log(req.user);
    res.render('home', {user: loggedUser})
})

app.get('/prod/new', (req, res) => {
    res.render('prod/new', { loggedUser: req.user})
})

app.post('/prod/new', (req, res) => {
  console.log('POST - /prod/new')
  let newProd = req.body;
  newProd.createdBy = req.user;
  newProd.price = parseFloat(newProd.price)
  console.log(newProd)
  mongoRepository.saveProd(req.body).then((insertedProd) => {
    console.log('Inserted Product')
    console.log(insertedProd)
    res.redirect('/prod/list')
  })
})

app.get('/prod/list', (req, res) => {
  console.log('GET - /prod/list')
  mongoRepository.getProdsByUser(req.user).then((foundProds) => {
    res.render('prod/list', { loggedUser: req.user, products: foundProds})
  })
})


app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})
