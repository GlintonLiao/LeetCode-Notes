var bitwiseComplement = function(n) {
  let str = n.toString(2)
  let result = ''

  for (let i = 0; i < str.length; i++) {
    result += str[i] == '1' ? '0' : '1'
  }

  return parseInt(result, 2)
}