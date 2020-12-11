def cakes(recipe, available)
  possible = []
  available.map do |k,v|
    return 0 if !recipe[k]
    v / recipe[k]
  end.min()
  
end