/*
 * Copyright (c) 2015 Cloudera, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cloudera.nav.sdk.client;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.TrustManager;

/**
 * A set of configuration options needed by the Navigator plugin
 */
public class ClientConfig {

  private String navigatorUrl;
  private int apiVersion;
  private String applicationUrl;
  private String namespace;
  private String username;
  private String password;
  private Format format;
  private boolean autocommit;
  private boolean disableSSLValidation;
  private TrustManager overrideTrustManager;
  private HostnameVerifier overrideHostnameVerifier;
  private String sslTrustStoreType;
  private String sslTrustStoreLocation;
  private String sslTrustStorePassword;

  /**
   * @return Location of Navigator
   */
  public String getNavigatorUrl() {
    return navigatorUrl;
  }

  /**
   * Sets the URL for Navigator
   * @param navigatorUrl new URL for Navigator
   */
  public void setNavigatorUrl(String navigatorUrl) {
    this.navigatorUrl = navigatorUrl;
  }

  /**
   * Return the Navigator API version number. For publishing metadata to
   * Navigator 7 is the minimum required. For creating managed custom properties
   * 9 is the minimum required.
   */
  public int getApiVersion() {
    return apiVersion;
  }

  /**
   * Set the Navigator API version number
   * @param apiVersion
   */
  public void setApiVersion(int apiVersion) {
    this.apiVersion = apiVersion;
  }

  /**
   * @return application namespace assigned by Navigator
   */
  public String getNamespace() {
    return namespace;
  }

  /**
   * Set the application namespace assigned by Navigator
   * @param namespace
   */
  public void setNamespace(String namespace) {
    this.namespace = namespace;
  }

  /**
   * Navigator username
   * @return
   */
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * Navigator password
   * @return
   */
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * @return the client application URL (used to record the source of
   *         custom entities
   */
  public String getApplicationUrl() {
    return applicationUrl;
  }

  public void setApplicationUrl(String applicationUrl) {
    this.applicationUrl = applicationUrl;
  }

  /**
   * @return the file format used to read and write
   */
  public Format getFormat() {
    return format;
  }

  public void setFormat(Format format) {
    this.format = format;
  }

  public boolean isAutocommit() {
    return autocommit;
  }

  public void setAutocommit(boolean autocommit) {
    this.autocommit = autocommit;
  }

  public void setDisableSSLValidation(boolean disableSSLValidation) {
    this.disableSSLValidation = disableSSLValidation;
  }

  /**
   * Whether to skip SSL certificate Validation altogether
   */
  public boolean isDisableSSLValidation() {
    return disableSSLValidation;
  }

  public TrustManager getOverrideTrustManager() {
    return overrideTrustManager;
  }

  public void setOverrideTrustManager(TrustManager overrideTrustManager) {
    this.overrideTrustManager = overrideTrustManager;
  }

  public HostnameVerifier getOverrideHostnameVerifier() {
    return overrideHostnameVerifier;
  }

  public void setOverrideHostnameVerifier(HostnameVerifier overrideHostnameVerifier) {
    this.overrideHostnameVerifier = overrideHostnameVerifier;
  }

  public String getSSLTrustStoreLocation() {
    return sslTrustStoreLocation;
  }

  public void setSSLTrustStoreLocation(String sslTrustStoreLocation) {
    this.sslTrustStoreLocation = sslTrustStoreLocation;
  }

  public String getSSLTrustStorePassword() {
    return sslTrustStorePassword;
  }

  public void setSSLTrustStorePassword(String sslTrustStorePassword) {
    this.sslTrustStorePassword = sslTrustStorePassword;
  }

  public String getSslTrustStoreType() {
    return sslTrustStoreType;
  }

  public void setSslTrustStoreType(String sslTrustStoreType) {
    this.sslTrustStoreType = sslTrustStoreType;
  }


}
