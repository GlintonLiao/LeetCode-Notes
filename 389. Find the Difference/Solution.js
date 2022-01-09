/**
 * @param {string} s
 * @param {string} t
 * @return {character}
 */
 var findTheDifference = function(s, t) {
  let charCode = t.charCodeAt(t.length - 1)
  for (let i = 0; i < s.length; i++) {
      charCode -= s.charCodeAt(i)
      charCode += t.charCodeAt(i)
  }
  return String.fromCharCode(charCode)
};
