(ns callumherries.posts
  (:require [markdown-to-hiccup.core :as m]
            [shadow.resource :as rc]))

#?(:clj (defn clj-inline [resource-path]
          (slurp (str "./src/callumherries" (subs resource-path 1)))))

;; for more about rc/inline, see
;; https://clojureverse.org/t/using-none-code-resources-in-cljs-builds/3745
(def posts-data
  [
   {:title    "Don't get bored"
    :date     "2017-02-17"
    :page-key :posts/dont-get-bored
    :url-name "dont-get-bored"
    :md       #?(:clj (clj-inline "./posts/2017-02-17-dont-get-bored.md")
                 :cljs (rc/inline  "./posts/2017-02-17-dont-get-bored.md"))}
   {:title    "The hacker mentality, for life"
    :date     "2017-02-20"
    :page-key :posts/hacker-mentality
    :md       #?(:clj (clj-inline "./posts/2017-02-20-hacker-mentality.md")
                 :cljs (rc/inline   "./posts/2017-02-20-hacker-mentality.md"))}
   {:title    "10 common fallacies programmers make"
    :date     "2017-02-21"
    :page-key :posts/common-fallacies
    :md       #?(:clj (clj-inline "./posts/2017-02-21-10-common-fallacies.md")
                 :cljs (rc/inline "./posts/2017-02-21-10-common-fallacies.md"))}
   {:title    "Turning 20 in the age of uncertainty"
    :date     "2017-02-22"
    :page-key :posts/turning-20
    :md       #?(:clj (clj-inline "./posts/2017-02-22-turning-20.md")
                 :cljs (rc/inline "./posts/2017-02-22-turning-20.md"))}
   {:title    "A letter to my 20-year-old self, from my 60-year-old self"
    :date     "2017-02-23"
    :page-key :posts/letter-to-20-year-old-self
    :md       #?(:clj (clj-inline "./posts/2012-02-23-letter-from-60-year-old-self.md")
                 :cljs (rc/inline "./posts/2012-02-23-letter-from-60-year-old-self.md"))}
   {:title    "Piping Python"
    :date     "2020-10-13"
    :page-key :posts/piping-python
    :md       #?(:clj (clj-inline "./posts/2020-10-13-piping-python.md")
                 :cljs (rc/inline "./posts/2020-10-13-piping-python.md"))}
   ])
