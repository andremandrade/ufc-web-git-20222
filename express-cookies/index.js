const express = require('express')
var cookieSession = require('cookie-session')
const app = express()
const port = 3000

app.set('view engine', 'ejs');
app.set('views', './views');

app.use(cookieSession({
  name: 'ufc-web-session',
  secret: 'c293x8b6234z82n938246bc2938x4zb234',
  maxAge: 24 * 60 * 60 * 1000 // 24 hours
}))

app.get('/logout', (req, res) => {
  req.session = null
  res.redirect('/')
})

app.use((req, res, next) => {
  console.log('== Session Log Middleware');
  console.log(req.session);
  next();
});

app.use((req, res, next) => {
  console.log('== Root Middleware');
  if(req.path == '/'){
    if(req.session.user){
      console.log('Go home')
      res.redirect('/home')
    } else next();
  } else next();
});

app.use(express.static('public'));
app.use(express.json())
app.use(express.urlencoded({ extended: true }))

const mongoRepository = require('./repository/mongo-repository')

app.post('/login', (req, res) => {
  console.log('post - /login')
  console.log(req.body)
  mongoRepository.getUsers(req.body.login, req.body.pass).then(users => {
    if (users.length > 0){
      req.session.user = users[0]
      res.redirect('/home')
      return 
    } else res.redirect('/')
  });
})

app.use((req, res, next) => {
  console.log('== Auth Middleware')
  console.log(req.session)
  if(req.session.user){
    next()
  }
  else res.redirect('/')

})

app.get('/home',(req,res) => {
  res.render('home', {user: req.session.user})
})

app.use('/student/*',(req, res, next) => {
  console.log('== Student Area Middleware')
  console.log(req.session)
  if(req.session.user.role == 'student'){
    next()
  }
  else res.redirect('/home')
})

app.get('/student/home',(req,res) => {
  res.render('student/home', {user: req.session.user})
})

app.use('/admin/*',(req, res, next) => {
  console.log('== Admin Area Middleware')
  console.log(req.session)
  if(req.session.user.role == 'admin'){
    next()
  }
  else res.redirect('/home')
})

app.get('/admin/home',(req,res) => {
  res.render('admin/home', {user: req.session.user})
})

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})
