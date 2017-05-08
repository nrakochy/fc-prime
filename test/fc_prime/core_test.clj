(ns fc-prime.core-test
  (:require [clojure.test :refer :all]
            [fc-prime.core :refer :all]))

(def first-ten-primes [2 3 5 7 11 13 17 19 23 29])
(def multiples-five [5 10 15 20 25]) 

(deftest is-not-multiple?-test
  (let [prime (first first-ten-primes)
        multiple (* prime 2)
        prime-as-param (last first-ten-primes)]
    (testing "returns false when param is a multiple of given prime"
      (is (= false (is-not-multiple? multiple prime))))
    (testing "returns false when param is equal to given prime" 
      (is (= false (is-not-multiple? prime prime))))
    (testing "returns true when param is not multiple of given prime"
      (is (= true (is-not-multiple? prime-as-param prime))))))

(deftest filter-multiples-test
  (testing "filters and returns empty sequence where all numbers in collection are multiples of given prime"
    (let [expected-result (sequence '())]
      (is (= expected-result (filter-multiples multiples-five))))
  (testing "filters and returns sequable collection where num is not a multiple of given prime"
    (let [expected-result (rest first-ten-primes)]
      (is (= expected-result (filter-multiples first-ten-primes)))))))

(deftest terminate-prime-finder?-test 
  (testing "returns true if results size is equal to requested number of primes"
    (let [requested-num 2
          two-primes (take requested-num first-ten-primes)]
      (is (= true (terminate-prime-finder? requested-num two-primes (range 2))))))
  (testing "returns true if reduced collection is empty" 
    (let [requested-num 1000
          empty-seq (sequence '())]
      (is (= true (terminate-prime-finder? requested-num first-ten-primes empty-seq)))))
  (testing "returns false if requested num of primes has not been reached and there are still numbers in the
           reduced collection param"
    (let [requested-num 1000]
            (is (= false (terminate-prime-finder? requested-num [] first-ten-primes))))))
