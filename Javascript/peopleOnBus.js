var number = function(busStops){
  return busStops.reduce((total,[enter,exit]) => total + enter - exit , 0 );
}