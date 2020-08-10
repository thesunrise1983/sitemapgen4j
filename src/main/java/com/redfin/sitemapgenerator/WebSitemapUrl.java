package com.redfin.sitemapgenerator;

import java.net.MalformedURLException;
import java.net.URL;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Encapsulates a single URL to be inserted into a Web sitemap (as opposed to a Geo sitemap, a Mobile sitemap, a Video
 * sitemap, etc which are Google specific). Specifying a lastMod, changeFreq, or priority is optional; you specify those
 * by using an Options object.
 *
 * @author  Dan Fabulich
 * @see     Options
 */
public class WebSitemapUrl implements ISitemapUrl {
    private final URL url;
    private final Date lastMod;
    private final ChangeFreq changeFreq;
    private final Double priority;
    private final List<Alternate> alternates;

    /**
     * Encapsulates a single simple URL.
     */
    public WebSitemapUrl(final String url) throws MalformedURLException {
        this(new URL(url));
    }

    /**
     * Encapsulates a single simple URL.
     */
    public WebSitemapUrl(final URL url) {
        this.url = url;
        this.lastMod = null;
        this.changeFreq = null;
        this.priority = null;
        this.alternates = new ArrayList<Alternate>();

    }

    /**
     * Creates an URL with configured options.
     */
    public WebSitemapUrl(final Options options) {
        this.url = options.url;
        this.lastMod = options.lastMod;
        this.changeFreq = options.changeFreq;
        this.priority = options.priority;
        this.alternates = options.alternates;
    }

    /**
     * Retrieves the {@link Options#lastMod(Date)}.
     */
    public Date getLastMod() {
        return lastMod;
    }

    /**
     * Retrieves the {@link Options#changeFreq(ChangeFreq)}.
     */
    public ChangeFreq getChangeFreq() {
        return changeFreq;
    }

    /**
     * Retrieves the {@link Options#priority(Double)}.
     */
    public Double getPriority() {
        return priority;
    }

    /**
     * Retrieves the url.
     */
    public URL getUrl() {
        return url;
    }

    /**
     * Options to configure web sitemap URLs.
     */
    public static class Options extends AbstractSitemapUrlOptions<WebSitemapUrl, Options> {

        private List<Alternate> alternates;

        /**
         * Configure this URL.
         */
        public Options(final String url) throws MalformedURLException {
            this(new URL(url));
        }

        /**
         * Configure this URL.
         */
        public Options(final URL url) {
            super(url, WebSitemapUrl.class);
        }

        public Options alternates(final List<Alternate> alternates) {
            this.alternates = alternates;
            return this;
        }
    }

    public List<Alternate> getAlternates() {
        return this.alternates;
    }
}
