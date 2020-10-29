function getPINs(observed) {
  const possible = [];

  observed.split("").forEach(char => {
    const digit = parseInt(char);
    possible.push( variations(digit) )
  });

  possible.forEach(x => console.log(x));

}

const add2dVector = (vec1,vec2) =>
{
  const [x1,y1] = vec1
  const [x2,y2] = vec2

  return [x1+x2,y1+y2]
}
//get all variations for the current digit
//int => [Strings 1 char long]
const variations = digit => {
  const coords = pinToCoord(digit);
  const possible = [digit.toString()];

  [ //add/subtract 1 from x,y each
    [1,0],[-1,0],[0,1],[0,-1]  
  ].forEach(vect => {
    const pin = coordToPin(add2dVector(vect,coords));
    pin != undefined && possible.push(pin.toString());
  });
  return possible;
}
// [int,int] => int || null
const coordToPin = ([x,y]) => {
  const pinMap = []
  pinMap[1] = [,1,2,3];
  pinMap[2] = [,4,5,6];
  pinMap[3] = [,7,8,9];
  pinMap[4] = [, ,0]

  const pinRow = pinMap[y];

  if(pinRow === undefined)
    return pinRow;
  
  return pinRow[x];  
}

// int => [int,int];
const pinToCoord = (pinDigit) => {
  const coordMap = {
    1: [1,1], 2: [2,1], 3: [3,1],
    4: [1,2], 5: [2,2], 6: [3,2],
    7: [1,3], 8: [2,3], 9: [3,3],
              0: [2,4]
  }
  return coordMap[pinDigit];
}