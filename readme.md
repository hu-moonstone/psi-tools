# Tools for PageSpeed Insight

## Get score

This command outputs score information(json) to standard output.
```
$ node app.js arg1 arg2
```

- arg1 : Target url
- arg2 : Set "mobile" or "desktop"

```
Example)
$ node app.js http://example.com mobile
```

## Build

### 1.Install clj
```
$ curl -O https://download.clojure.org/install/linux-install-1.9.0.397.sh
$ chmod +x linux-install-1.9.0.397.sh
$ sudo ./linux-install-1.9.0.397.sh
```

### 2.Compile
```
$ clj -m cljs.main --target node --output-to app.js -c pagespeed.core
```

