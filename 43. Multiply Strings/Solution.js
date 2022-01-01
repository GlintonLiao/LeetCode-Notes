var multiply = function(num1, num2) {
  // deal with the edge case
  if (num1 == '0' || num2 == '0') {
    return 0
  }

  // create the result container
  let result = new Array(num1.length + num2.length).fill(0)

  for (let i = num1.length - 1; i >= 0; i--) {
    for(let j = num2.length - 1; j >= 0; j--) {
      let product = parseInt(num1[i]) * parseInt(num2[j])
      let carry = product + result[i+j+1]
      result[i+j+1] = carry % 10
      result[i+j] += carry / 10
    }
  }

  // remove the comma of the str
  let str = result.toString().replace(/,/g, '')
  // remove the front 0 of the str
  return str[0] == '0' ? str.slice(1) : str

}