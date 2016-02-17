/**
 * http://usejsdoc.org/
 */
var express = require('express');
var router = express.Router();

// middleware that is specific to this router
router.use(function(req, res, next) {
  console.log('Time: ', Date.now());
  
  res.set("abcd", "ABCD...!!");
  next();
});

// define the home page route
router.get('/', function(req, res) {
  console.log(res.get("abcd"));
  res.send('Birds home page');
});

// define the about route
router.get('/about', function(req, res) {
  res.send('About birds');
});

module.exports = router;