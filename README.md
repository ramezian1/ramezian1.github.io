# ramezian1.github.io

Personal portfolio and project showcase — live at **[ramezian.dev](https://ramezian.dev)**

## Stack

Plain HTML, CSS, and JavaScript. No frameworks, no build step, deployed directly via GitHub Pages.

## Features

- Dark / light mode with `prefers-color-scheme` fallback and localStorage persistence
- Smooth page transitions via the View Transitions API
- Scroll-reveal animations and sticky frosted-glass nav
- Responsive mobile layout with hamburger menu
- Project cards with screenshot carousels and lightbox
- [`/uses`](https://ramezian.dev/uses.html) page

## Projects

| Project | Description |
|---|---|
| [react-sync](https://github.com/ramezian1/react-sync) | Chrome extension for syncing video playback across tabs — live on the Chrome Web Store |
| [hifi-audio-log](https://github.com/ramezian1/hifi-audio-log) | React Native app for cataloging audio gear and EQ profiles |
| [resume-tailor](https://github.com/ramezian1/resume-tailor) | AI tool that rewrites resume bullets to match job descriptions using the Claude API |
| [financetracker](https://github.com/ramezian1/financetracker) | Browser-based personal finance tracker with Chart.js visualizations |

## Structure

```
index.html        — main portfolio page
uses.html         — tools and gear page
style.css         — all styles (CSS custom properties for theming)
script.js         — theme toggle, nav, scroll reveal, carousels, transitions
resume.pdf        — downloadable resume
favicon.svg       — site icon
assets/           — project screenshots
react-sync/store/ — privacy policy for the Chrome extension
```
