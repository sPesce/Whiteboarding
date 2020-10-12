var number = function(busStops){
  return busStops.reduce((solution,[enter,exit]) => {return solution + enter - exit},0);
}