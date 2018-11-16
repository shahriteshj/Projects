var fname:string="John";

//console.log("Hello World" + fname);

function greeter(person:String) {
    return "Hello, " + person;
}

let user = "Jane User";

document.body.innerHTML = greeter(user);