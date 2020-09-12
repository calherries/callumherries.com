(defproject callumherries "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.clojure/clojurescript "1.10.742"]
                 [thheller/shadow-cljs "2.8.109"]
                 [bidi "2.1.6"]
                 [binaryage/devtools "0.9.10"]
                 [reagent "1.0.0-alpha2"]
                 [markdown-to-hiccup "0.6.2"]
                 [venantius/accountant "0.2.5"]
                 [orgpad/volcano "0.1.2"]]

  :plugins []

  :main callumherries.build

  :source-paths ["src"]


  :clean-targets ^{:protect false} ["resources/js" "target" ]

  )
