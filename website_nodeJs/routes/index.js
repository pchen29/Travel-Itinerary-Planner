var express = require('express');
var router = express.Router();
var setUserInput=require('../controllers/userInput');
var http = require('follow-redirects').http;
var fs = require('fs');
/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', { title: 'Express' });
});
router.post('/start', function(req, res, next) {
  let email=req.body.address;
  console.log(email);
  res.render('userInput', { title: 'Express',email:email });
});
router.post('/input', setUserInput.insertInput);



module.exports = router;
