const express = require('express');
const mongoose = require('mongoose');

const app = express();
mongoose.connect('mongodb://mongo:27017/test', {
  useNewUrlParser: true,
  useUnifiedTopology: true,
});

app.get('/', (req, res) => res.send('Hello from Node App with MongoDB!'));
app.listen(3000, () => console.log('App running on port 3000'));
