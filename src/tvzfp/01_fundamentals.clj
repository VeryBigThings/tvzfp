(ns tvzfp.01-fundamentals
  (:require [clojure.string :refer [join]]))

; ============= Basic LISP syntax ======================
; def x = 7   --> (def x 7)
; f (x)       --> (f x)

(def broj 21)
(number? broj)
(str "Dobar dan svima, " broj " vas ima!")

(+ broj 1)
(* broj 2)

(def numbers [1 2 3])
(contains? numbers 1)
(contains? numbers 42)
(conj numbers 42)
(contains? numbers 42)

(def words '("šije" "šete" "oto"))
(count words)
(conj words "nove")
(join "," words)

; ======================= Functions ===================

(fn [x] x)

; ---

(def add2nums
  (fn [x y] (+ x y)))

(add2nums 1 2)

; ---

(defn add3nums [x y z]
  (+ x y z))

(add3nums 1 2 3)

; ---

;; (apply f [x y z]) == (f x y z) 
(defn add-many-nums [& nums]
  (apply + nums))

(add-many-nums 1 2 3 4 5)

; --- Operators also have arbitrary arity
(+ 1 2 3 4 5 6)
(+ 1)

;; === TASKS ===
;; implement:
;; - add1
;; - make-adder
;; - make-op
;; - add-and-mult using above
;; - re-implement using built-in math ops
;; - finally, calculate bellow, using all of the above

#_(-> 2
      add13
      mult6
      sub6
      div2)