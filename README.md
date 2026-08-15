# ramezian1.github.io

Personal portfolio and project showcase — live at **[robertmezian.com](https://robertmezian.com)**

## Stack

Plain HTML, CSS, and JavaScript. No frameworks, no build step, deployed directly via GitHub Pages.

## Features

- Dark / light mode with `prefers-color-scheme` fallback and localStorage persistence
- Smooth page transitions via the View Transitions API
- Scroll-reveal animations and sticky frosted-glass nav
- Responsive mobile layout with hamburger menu
- Project cards with screenshot carousels and lightbox
- [`/uses`](https://robertmezian.com/uses) and [`/contact`](https://robertmezian.com/contact) pages
- Custom 404 page

## Projects

| Project | Description |
|---|---|
| [watchalong](https://github.com/ramezian1/watchalong) | Syncs reaction videos with streaming services via a Chrome extension bridge — live at [watch-alongs.com](https://www.watch-alongs.com) |
| [hifi-audio-log](https://github.com/ramezian1/hifi-audio-log) | React Native app for cataloging audio gear and EQ profiles |
| [resume-tailor](https://github.com/ramezian1/resume-tailor) | AI tool that rewrites resume bullets to match job descriptions using the Claude API |
| [financetracker](https://github.com/ramezian1/financetracker) | Browser-based personal finance tracker with Chart.js visualizations |

## Structure

```
index.html        — main portfolio page
contact/          — contact page (served at /contact)
uses/             — tools and gear page (served at /uses)
404.html          — custom not-found page
style.css         — all styles (CSS custom properties for theming)
script.js         — theme toggle, nav, scroll reveal, carousels, transitions
resume.pdf        — downloadable resume
favicon.svg       — site icon
assets/           — project screenshots
CNAME             — custom domain for GitHub Pages
```
