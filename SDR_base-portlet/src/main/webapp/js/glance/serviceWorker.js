importScripts('workbox-sw.prod.v2.1.2.js');

const workboxSW = new self.WorkboxSW({ clientsClaim: true });
workboxSW.precache([
  {
    "url": "glance-external-ITKReader.js",
    "revision": "6a914928bd307dac1e797d51d5af3aa2"
  },
  {
    "url": "glance-external-Workbox.js",
    "revision": "dbb9e7e0a08c5de511246dfae8475f7e"
  },
  {
    "url": "index.html",
    "revision": "cad407bac459cdf65fd1f0d9758c8c31"
  },
  {
    "url": "ParaView.png",
    "revision": "08ff220c5c71d1534ce3de8fe00e8f0c"
  },
  {
    "url": "ParaView.svg",
    "revision": "6ac08a58bd33774917ed4573f26ca38d"
  },
  {
    "url": "workbox-sw.prod.v2.1.2.js",
    "revision": "685d1ceb6b9a9f94aacf71d6aeef8b51"
  }
]);

workboxSW.router.registerRoute(
  /\.js|\.png|\.wasm$/,
  workboxSW.strategies.staleWhileRevalidate({
    cacheName: 'staleWhileRevalidateContent',
    cacheExpiration: {
      maxEntries: 50,
      maxAgeSeconds: 7 * 24 * 60 * 60 * 26,
    },
  })
);
