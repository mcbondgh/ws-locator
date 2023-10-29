import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/form-layout/src/vaadin-form-layout.js';
import '@vaadin/email-field/src/vaadin-email-field.js';

@customElement('my-view')
export class MyView extends LitElement {
  static get styles() {
    return css`
      :host {
          display: block;
          height: 100%;
      }
      `;
  }

  render() {
    return html`
<vaadin-horizontal-layout class="content" style="width: 100%; height: 100%;"></vaadin-horizontal-layout>
<vaadin-form-layout style="width: 100%; height: 100%;"></vaadin-form-layout>
<vaadin-email-field type="email"></vaadin-email-field>
`;
  }

  // Remove this method to render the contents of this view inside Shadow DOM
  createRenderRoot() {
    return this;
  }
}
