def cakes(recipe, available)
  recipe.map{|k,v| available[k] ? available[k] / v : 0}.min()
end