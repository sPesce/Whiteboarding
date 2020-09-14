//Growth of a Population
//input: p0, percent, aug (inhabitants coming or leaving each year), p (population to surpass)
//output: number - how many years will it take to reach 'p'?
function nbYear(p0, percent, aug, p) {

  const population = (pn,n = 0) =>
  {
    const pNext = pn*( 1 + (percent/100)) + aug    
    return (pn >= p) ? n : population(pNext, n + 1)
  }
  
  return population(p0)
}
