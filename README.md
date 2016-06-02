# Problem

I have a Clojure application that I use as a terminal program. I want to use it in a browser as a simple webapp. How can I without learning the entire web stack?

# Re-frame to the rescue

[Re-frame](https://github.com/Day8/re-frame) is a beautiful way to organize your webapps which sits on top of [Reagent](http://reagent-project.github.io/), which is a minimalistic wrapper for [React.js](https://facebook.github.io/react/). This repository contains an almost-minimal re-frame application as well as a skeleton Clojure/ClojureScript library that represents your library that needs webification.

This library and its eponymous namespace, called `awesome-app`, has `cljc` file extensions:  it can be compiled to Clojure or ClojureScript because if you started with a Clojure library, you probably want to avoid ClojureScript-only features creeping in. As such, you probably have some work to do removing JVM-only Clojure features from your library to prepare it for ClojureScript, and `cljc` lets you be organized about these differences---`cljc` files allow the use of [reader conditionals](http://clojure.org/guides/reader_conditionals) to specify alternate code for JVM Clojure, JavaScript ClojureScript, etc.

# Usage

## Development Mode

### Run application:

```
lein clean
lein figwheel dev
```

Figwheel will automatically push cljs changes to the browser.

Wait a bit, then browse to [http://localhost:3449](http://localhost:3449).

## Production Build
To build an optimized and minified JavaScript payload:
```
lein clean
lein cljsbuild once min
```
Then make the `resources/public` directory available on the web (via Nginx, Apache, GitHub Pages, etc.).
