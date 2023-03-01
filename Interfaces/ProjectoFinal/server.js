const express = require("express");
const app = express();


const PORT = 3000;
app.listen(PORT, () => {
    console.log(`Server opnening on port ${PORT}`)
});

app.get('/a', (req,res) =>{
    res.sendFile(__dirname + '/public/a.html')
})
