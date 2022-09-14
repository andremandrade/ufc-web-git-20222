const express = require('express')
const app = express()
const port = 3000

app.use(express.json())
app.use(express.urlencoded({ extended: true }))

app.post('/mirror', function (req, res, next) {
  console.log(req.body)
  res.send(req.body)
})

app.get('/', (req, res) => {
  res.send('<h1>Web - Aula Git</h1>')
})

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})
