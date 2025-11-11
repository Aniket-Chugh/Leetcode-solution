
var expect = function (val) {
  function toBe(data) {
    if (data === val) {
      return true; 
    } else {
        throw new Error("Not Equal");
    }
  }

  function notToBe(value) {
    if (value !== val) {
      return true; 
    } else {
     throw new Error("Equal")
    }
  }

  return { toBe, notToBe };  
}

