(ns tvzfp.03-recursion)

;; Implement map, filter and reduce from scratch, using iterative recursion

;; Test cases (remove the #_ prefix and eval to test if your implementation works)
#_(= (my-map inc [1 2 3 4 5]) [2 3 4 5 6])
#_(= (my-filter even? [1 2 3 4 5]) [2 4])
#_(= (my-reduce + [1 2 3 4 5]) 15)