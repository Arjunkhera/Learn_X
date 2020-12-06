let product = {
    "name" : "iphone",
    "price" : "123",
    "company" : "Apple"
  }
  
  let {name, price, company:alias} = product;
  console.log(name);
  console.log(alias);