const express = require('express')
const app = express()
const port = 3000

app.get('/', (req, res) => {
  res.send('mudando o nome!')
})

app.get('/querytojson', (req, res) => {
  console.log(req.query);
  res.send(req.query);
})

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})
