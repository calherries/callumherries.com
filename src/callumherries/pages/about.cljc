(ns callumherries.pages.about
  (:require [callumherries.routes :as routes]
            [bidi.bidi :as b]))

(defn hiccup []
  [:div.vbox.flex
   [:h1.font-mono "About"]
   [:p "I live in Amsterdam and work as an analyst for Uber Freight. I mostly use Python for my day job, but I have an interest in functional programming languages (mostly Clojure and Haskell)."]
   [:p "I learn best through completing projects and writing about them, hence this website."]
   [:p [:a {:href "mailto:hi@callumherries.com"} "Email me"] " if you want to get in touch." ]
   [:p "You can also find me as " [:a {:href "https://github.com/callum-herries"} "callum-herries"] " on Github"
    , ", " [:a {:href "https://twitter.com/home"} "callumherries"] " on Twitter."]])
