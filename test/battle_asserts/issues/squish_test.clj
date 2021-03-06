(ns battle-asserts.issues.squish-test
  (:require [clojure.test :refer :all]
            [clojure.test.check.properties :as prop :include-macros true]
            [clojure.test.check.clojure-test :as ct :include-macros true]
            [clojure.string :as s]
            [test-helper :as h]
            [battle-asserts.issues.squish :as issue]))

(ct/defspec spec-solution
  20
  (prop/for-all [v (issue/arguments-generator)]
                (= (apply issue/solution v)
                   (s/replace (first v) #"\s+" " "))))

(deftest test-solution
  (h/generate-tests issue/test-data issue/solution))
