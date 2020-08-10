package com.redfin.sitemapgenerator;

import java.net.MalformedURLException;
import java.net.URL;

public class Alternate {
    private final URL url;
    private final String hreflang;

    public Alternate(final URL url, final String hreflang) {
        this.url = url;
        this.hreflang = hreflang;
    }

    /**
     * Retrieves URL of Image.
     */
    public URL getUrl() {
        return url;
    }

    /**
     * Retrieves title of image.
     */
    public String getHreflang() {
        return hreflang;
    }

    public static class AlternateBuilder {
        private URL url;
        private String hreflang;

        public AlternateBuilder(final String url) throws MalformedURLException {
            this(new URL(url));
        }

        public AlternateBuilder(final URL url) {
            this.url = url;
        }

        public AlternateBuilder hreflang(final String hreflang) {
            this.hreflang = hreflang;
            return this;
        }

        public Alternate build() {
            return new Alternate(url, hreflang);
        }
    }
}
