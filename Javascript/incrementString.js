function incrementString (strng) {
  const peices = strng.split(/(\d+$)/);
  if(peices.length === 1)
    return peices[0] + "1";

  const [inpStr,numberStr,] = peices;  
  const count = parseInt( numberStr ) + 1;

  if(!numberStr.startsWith('0')) return inpStr + count;

  const zeroes = zeroCount(numberStr);

  
      
  
  
  
  zeroes = (numberStr.match(/^0+$/)) ? zeroes - 1 : zeroes;
  zeroes = (count % 10 === 0) ? zeroes - 1 : zeroes; 
  
  return inpStr + '0'.repeat(zeroes) + count;
}

const zeroCount = numberStr => {
  const [,zeroes,num] = numberStr.split(/(^0+)/);
  return !num ? zeroes - 1 : zeroes;
}