// Execute after Swagger UI is fully loaded
window.onload = function() {
    // Add custom header or banner
    const topbarWrapper = document.querySelector('.swagger-ui .topbar-wrapper');
    if (topbarWrapper) {
        const banner = document.createElement('div');
        banner.className = 'custom-banner';
        banner.innerHTML = '<span>Custom Swagger UI Demo</span>';
        banner.style.textAlign = 'center';
        banner.style.padding = '10px';
        banner.style.backgroundColor = '#f8f9fa';
        banner.style.borderBottom = '1px solid #dee2e6';
        banner.style.color = '#3f51b5';
        banner.style.fontWeight = 'bold';

        const topbar = document.querySelector('.swagger-ui .topbar');
        if (topbar && topbar.parentNode) {
            topbar.parentNode.insertBefore(banner, topbar.nextSibling);
        }
    }

    // Add event listeners or custom behavior
    const authorizeBtn = document.querySelector('.swagger-ui .auth-wrapper .authorize');
    if (authorizeBtn) {
        const originalClick = authorizeBtn.onclick;
        authorizeBtn.onclick = function(e) {
            console.log('Custom authorize button clicked');
            if (originalClick) {
                originalClick.call(this, e);
            }
        };
    }

    // Modify existing elements
    const infoTitle = document.querySelector('.swagger-ui .info .title');
    if (infoTitle) {
        infoTitle.style.fontFamily = 'Arial, sans-serif';
    }

    console.log('Custom Swagger UI script loaded successfully!');
};
