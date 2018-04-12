(ns four-clojure.core
  (:gen-class))

(defn my-last 
  "Returns last element of a collection"
  [collection]
  (first (drop (- (count collection) 1) collection)))

(defn my-penultimate
  [collection]
  (first (drop (- (count collection) 2) collection)))

(defn my-nth-element
  "Returns the nth element of a sequence"
  [collection nth-element]
  (first (drop nth-element collection)))

