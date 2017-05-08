(ns fc-prime.core-test
  (:require [clojure.test :refer :all]
            [fc-prime.core :refer :all]))

(def first-ten-primes [2 3 5 7 11 13 17 19 23 29])

(deftest is-multiple-test
  (let [prime (first first-ten-primes)
        multiple (* prime 2)
        prime-as-param (last first-ten-primes)]
    (testing "returns true when param is a multiple of given prime"
      (is (= true (is-multiple? prime multiple))))
    (testing "returns true when param is equal to given prime" 
      (is (= true (is-multiple? prime prime))))
    (testing "returns false when param is not multiple of given prime"
      (is (= false (is-multiple? prime prime-as-param))))))



