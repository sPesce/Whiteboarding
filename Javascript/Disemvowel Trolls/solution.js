//input: string - a comment
//output: string - a comment with its vowels removed
//for censoring trolls
function disemvowel(str) {
  let vowels = ['a','e','i','o','u']
  
  let newStr = ''
  for(let i = 0; i < str.length; i++)
  {
    newStr += vowels.includes(str[i].toLowerCase()) ? '' : str[i]
  }
  return newStr;
}