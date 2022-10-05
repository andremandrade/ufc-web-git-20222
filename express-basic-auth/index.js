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
  // console.log(req.headers);
  next();
  // res.send('meu middleware bloqueou')
})

app.use(basicAuth({
  authorizer: userAuthorizer,
  challenge: true,
  authorizeAsync: true
}));

function userAuthorizer(username, password, callback){
  mongoRepository.getUsers(username, password).then(users => {
    console.log('userAuthorizer');
    console.log(users);
    callback(null, users.length == 0 ? false : true);
  });
}

app.get('/home',(req,res) => {
  basic = Buffer.from(req.headers.authorization.split(' ')[1], 'base64').toString().split(':');
  username = basic[0];
  password = basic[1];
  mongoRepository.getUsers(username, password).then(users => {
    console.log('/home');
    loggedUser = users[0];
    console.log(loggedUser);
    res.render('home', {user: loggedUser})
  });
})

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})
