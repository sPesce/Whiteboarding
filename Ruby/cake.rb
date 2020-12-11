def cakes(recipe, available)
  possible = []
  recipe.map do |k,v|
    return 0 if !available[k]
    available[k] / v
  end.min()  
end