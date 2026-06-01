const SVG_MOON = `<svg width="18" height="18" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><path d="M21 12.79A9 9 0 1 1 11.21 3 7 7 0 0 0 21 12.79z"/></svg>`;
const SVG_SUN  = `<svg width="18" height="18" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><circle cx="12" cy="12" r="5"/><line x1="12" y1="1" x2="12" y2="3"/><line x1="12" y1="21" x2="12" y2="23"/><line x1="4.22" y1="4.22" x2="5.64" y2="5.64"/><line x1="18.36" y1="18.36" x2="19.78" y2="19.78"/><line x1="1" y1="12" x2="3" y2="12"/><line x1="21" y1="12" x2="23" y2="12"/><line x1="4.22" y1="19.78" x2="5.64" y2="18.36"/><line x1="18.36" y1="5.64" x2="19.78" y2="4.22"/></svg>`;

// ── View Transitions ──────────────────────────────────
if (document.startViewTransition) {
  document.addEventListener('click', function(e) {
    var a = e.target.closest('a');
    if (!a || !a.href || a.target === '_blank' || a.href.startsWith('mailto:') || a.href.startsWith('#') || a.origin !== location.origin) return;
    e.preventDefault();
    document.startViewTransition(function() { location.href = a.href; });
  });
}

const root   = document.documentElement;
const toggle = document.getElementById('theme-toggle');

function setTheme(theme) {
  root.setAttribute('data-theme', theme);
  localStorage.setItem('theme', theme);
  toggle.innerHTML = theme === 'dark' ? SVG_SUN : SVG_MOON;
  var badge = document.getElementById('launch-badge');
  if (badge) badge.src = 'https://websitelaunches.com/badge/ramezian.dev.svg?theme=' + theme;
}

toggle.addEventListener('click', function() {
  setTheme(root.getAttribute('data-theme') === 'dark' ? 'light' : 'dark');
});

// Sync icon with current theme on load
setTheme(root.getAttribute('data-theme') || 'light');


// ── Active nav on scroll ──────────────────────────────
const sections  = document.querySelectorAll('main section[id]');
const navLinks  = document.querySelectorAll('.nav-links a');

var navObserver = new IntersectionObserver(function(entries) {
  entries.forEach(function(entry) {
    if (entry.isIntersecting) {
      navLinks.forEach(function(a) { a.classList.remove('active'); });
      var link = document.querySelector('.nav-links a[href="#' + entry.target.id + '"]');
      if (link) link.classList.add('active');
    }
  });
}, { rootMargin: '-40% 0px -55% 0px' });

sections.forEach(function(s) { navObserver.observe(s); });


// ── Scroll reveal ─────────────────────────────────────
var fadeObserver = new IntersectionObserver(function(entries) {
  entries.forEach(function(entry) {
    if (entry.isIntersecting) {
      entry.target.classList.add('visible');
      fadeObserver.unobserve(entry.target);
    }
  });
}, { threshold: 0.12 });

document.querySelectorAll('.fade-up').forEach(function(el) {
  fadeObserver.observe(el);
});


// ── Mobile nav ────────────────────────────────────────
var nav       = document.getElementById('nav');
var hamburger = document.getElementById('hamburger');
var mobileLinks = document.querySelectorAll('#nav-links a');

hamburger.addEventListener('click', function() {
  var open = nav.classList.toggle('nav-open');
  hamburger.setAttribute('aria-expanded', open ? 'true' : 'false');
});

mobileLinks.forEach(function(a) {
  a.addEventListener('click', function() {
    nav.classList.remove('nav-open');
    hamburger.setAttribute('aria-expanded', 'false');
  });
});


// ── Carousels ─────────────────────────────────────────
var lightbox    = document.getElementById('lightbox');
var lightboxImg = document.getElementById('lightbox-img');

document.querySelectorAll('.card-carousel').forEach(function(carousel) {
  var track = carousel.querySelector('.carousel-track');
  var imgs  = carousel.querySelectorAll('img');
  var dots  = carousel.querySelectorAll('.dot');
  var total = imgs.length;
  var idx   = 0;

  function goTo(n) {
    idx = (n + total) % total;
    track.style.transform = 'translateX(-' + (idx * 100) + '%)';
    dots.forEach(function(d, i) { d.classList.toggle('active', i === idx); });
  }

  carousel.querySelector('.prev').addEventListener('click', function(e) { e.stopPropagation(); goTo(idx - 1); });
  carousel.querySelector('.next').addEventListener('click', function(e) { e.stopPropagation(); goTo(idx + 1); });
  dots.forEach(function(d, i) { d.addEventListener('click', function(e) { e.stopPropagation(); goTo(i); }); });

  imgs.forEach(function(img) {
    img.addEventListener('click', function() {
      lightboxImg.src = img.src;
      lightboxImg.alt = img.alt;
      lightbox.classList.add('open');
    });
  });
});

lightbox.addEventListener('click', function() {
  lightbox.classList.remove('open');
  lightboxImg.src = '';
});

document.addEventListener('keydown', function(e) {
  if (e.key === 'Escape') { lightbox.classList.remove('open'); lightboxImg.src = ''; }
});


// ── Project Reel — seamless loop via cloning ──────────
var reelTrack = document.querySelector('.reel-track');
if (reelTrack) {
  var reelCards = Array.from(reelTrack.children);
  reelCards.forEach(function(card) {
    var clone = card.cloneNode(true);
    clone.setAttribute('aria-hidden', 'true');
    reelTrack.appendChild(clone);
  });

  // Drag-to-scroll — only suppress clicks when user actually dragged
  var isDragging = false, didDrag = false, startX = 0, scrollStart = 0;
  reelTrack.addEventListener('mousedown', function(e) {
    isDragging = true;
    didDrag = false;
    startX = e.clientX;
    scrollStart = reelTrack.parentElement.scrollLeft;
    reelTrack.style.animationPlayState = 'paused';
  });
  document.addEventListener('mousemove', function(e) {
    if (!isDragging) return;
    var dx = e.clientX - startX;
    if (Math.abs(dx) > 4) didDrag = true;
    reelTrack.parentElement.scrollLeft = scrollStart - dx;
  });
  document.addEventListener('mouseup', function() {
    if (!isDragging) return;
    isDragging = false;
    reelTrack.style.animationPlayState = '';
  });
  // Block click-through only when dragged, not on simple click
  reelTrack.addEventListener('click', function(e) {
    if (didDrag) { e.preventDefault(); e.stopPropagation(); didDrag = false; }
  }, true);
}
