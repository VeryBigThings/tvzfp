(ns tvzfp.02-data-pipelines
  (:require [tvzfp.core :refer [current-year]]))

;; =========== Teaser: seq iteration (map, filter & reduce) ==================

(def numbers [1 2 3 4 5])
(filter odd? numbers)
(map inc numbers)
(reduce + 0 numbers)
(group-by even? numbers)

;; ===================  Maps (and programming languages) =================

(def conventional-programming-languages
  {:java {:first-appeared 1995
          :exec-model :bytecode
          :mutable-data true
          :other-properties [:jvm
                             :object-oriented]}

   :python {:first-appeared 1991
            :exec-model :bytecode
            :mutable-data true
            :other-properties [:first-class-fns
                               :object-oriented
                               :significant-whitespace]}})

(def prog-langs
  (-> conventional-programming-languages
      (assoc :clojure {:first-appeared 2007
                       :exec-model :bytecode
                       :mutable-data false
                       :other-properties [:lisp
                                          :first-class-fns
                                          :java-hosted
                                          :jvm]})

      (merge {:haskell {:first-appeared 1990
                        :exec-model :binary
                        :mutable-data false
                        :other-properties [:ml-style-syntax
                                           :statically-typed
                                           :first-class-fns
                                           :lazy-evaluation]}

              :erlang {:first-appeared 1986
                       :exec-model :bytecode
                       :mutable-data false
                       :other-properties [:distributed
                                          :actor-based-concurrency
                                          :first-class-fns]}})))

;; What is Haskell like?
(get prog-langs :haskell)

;; Update Java attributes
(update prog-langs :java assoc :current-version 17)

;; Summary
; A functional programming language is a langugage 
; with AT LEAST the following two characteristics:
;     1. Functions are first class citizens
;     2. Data is immutable by default

;; ==================== Let, first & rest ====================

(let [first-lang (first prog-langs)
      other-langs (rest prog-langs)
      [second-lang-name _props] (first other-langs)
      other-lang-names (keys other-langs)]
  (str "Which one is better? " first-lang ", " second-lang-name " or " other-lang-names))


;; ==================== Tasks ====================
;; Tip extract predicates and mapping functions

(defn fp-langs
  "Given a collection of langugages, selects all the langugages
   that could be considered functional from the \"prog-langs\" map."
  [langs]
  #_TODO)

(defn lang-ages
  "Given a collection of langugages, calculates the the age of every language
   e.g. {:java {:age 25}}"
  [langs]
  #_TODO)

(defn oldest-lang
  "Given a collection of langugages, it finds the oldes programming language"
  [langs]
  #_TODO)

;; Final task
;; write code that determines what is the oldest programming
;; language that could also be considered functional.