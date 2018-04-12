(ns four-clojure.core-test
  (:require [clojure.test :refer :all]
            [four-clojure.core :refer :all]))

(deftest my-last-test
  (is (= (my-last [1 2 3 4 5]) 5))
  (is (= (my-last '(5 4 3)) 3))
  (is (= (my-last ["b" "c" "d"]) "d")))

(deftest my-penultimate-test
  (is (= (my-penultimate (list 1 2 3 4 5)) 4))
  (is (= (my-penultimate ["a" "b" "c"]) "b"))
  (is (= (my-penultimate [[1 2] [3 4]]) [1 2])))

(deftest my-nth-element-test
  (is (= (my-nth-element '(4 5 6 7) 2) 6))
  (is (= (my-nth-element [:a :b :c] 0) :a))
  (is (= (my-nth-element [1 2 3 4] 1) 2))
  (is (= (my-nth-element '([1 2] [3 4] [5 6]) 2) [5 6])))

(deftest my-count-test
  (is (= (my-count '(1 2 3 3 1)) 5))
  (is (= (my-count "Hello World") 11))
  (is (= (my-count [[1 2] [3 4] [5 6]]) 3)))

