function isValidWalk(walk) {

  let [xc,yc] = [0,0] //current location coord. pair
  
  //direction vectors
  const dirMap = {
    n: [0,1],
    s: [0,-1],
    e: [1,0],
    w: [-1,0]
  }
  walk.forEach(step => {
    xc += dirMap[step][0];
    yc += dirMap[step][1];
  })
  //[0,0] is the starting position
  return (xc === 0 && yc === 0 && walk.length === 10)
}