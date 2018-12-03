if (function(t, e) {
        "object" == typeof module && "object" == typeof module.exports ? module.exports = t.document ? e(t, !0) : function(t) {
            if (!t.document) throw new Error("jQuery requires a window with a document");
            return e(t)
        } : e(t)
    }("undefined" != typeof window ? window : this, function(t, e) {
        function n(t) {
            var e = t.length,
                n = rt.type(t);
            return "function" !== n && !rt.isWindow(t) && (!(1 !== t.nodeType || !e) || ("array" === n || 0 === e || "number" == typeof e && e > 0 && e - 1 in t))
        }

        function i(t, e, n) {
            if (rt.isFunction(e)) return rt.grep(t, function(t, i) {
                return !!e.call(t, i, t) !== n
            });
            if (e.nodeType) return rt.grep(t, function(t) {
                return t === e !== n
            });
            if ("string" == typeof e) {
                if (ut.test(e)) return rt.filter(e, t, n);
                e = rt.filter(e, t)
            }
            return rt.grep(t, function(t) {
                return rt.inArray(t, e) >= 0 !== n
            })
        }

        function r(t, e) {
            do {
                t = t[e]
            } while (t && 1 !== t.nodeType);
            return t
        }

        function o(t) {
            var e = gt[t] = {};
            return rt.each(t.match(mt) || [], function(t, n) {
                e[n] = !0
            }), e
        }

        function s() {
            ht.addEventListener ? (ht.removeEventListener("DOMContentLoaded", a, !1), t.removeEventListener("load", a, !1)) : (ht.detachEvent("onreadystatechange", a), t.detachEvent("onload", a))
        }

        function a() {
            (ht.addEventListener || "load" === event.type || "complete" === ht.readyState) && (s(), rt.ready())
        }

        function l(t, e, n) {
            if (void 0 === n && 1 === t.nodeType) {
                var i = "data-" + e.replace(wt, "-$1").toLowerCase();
                if ("string" == typeof(n = t.getAttribute(i))) {
                    try {
                        n = "true" === n || "false" !== n && ("null" === n ? null : +n + "" === n ? +n : _t.test(n) ? rt.parseJSON(n) : n)
                    } catch (t) {}
                    rt.data(t, e, n)
                } else n = void 0
            }
            return n
        }

        function u(t) {
            var e;
            for (e in t)
                if (("data" !== e || !rt.isEmptyObject(t[e])) && "toJSON" !== e) return !1;
            return !0
        }

        function c(t, e, n, i) {
            if (rt.acceptData(t)) {
                var r, o, s = rt.expando,
                    a = t.nodeType,
                    l = a ? rt.cache : t,
                    u = a ? t[s] : t[s] && s;
                if (u && l[u] && (i || l[u].data) || void 0 !== n || "string" != typeof e) return u || (u = a ? t[s] = X.pop() || rt.guid++ : s), l[u] || (l[u] = a ? {} : {
                    toJSON: rt.noop
                }), ("object" == typeof e || "function" == typeof e) && (i ? l[u] = rt.extend(l[u], e) : l[u].data = rt.extend(l[u].data, e)), o = l[u], i || (o.data || (o.data = {}), o = o.data), void 0 !== n && (o[rt.camelCase(e)] = n), "string" == typeof e ? null == (r = o[e]) && (r = o[rt.camelCase(e)]) : r = o, r
            }
        }

        function h(t, e, n) {
            if (rt.acceptData(t)) {
                var i, r, o = t.nodeType,
                    s = o ? rt.cache : t,
                    a = o ? t[rt.expando] : rt.expando;
                if (s[a]) {
                    if (e && (i = n ? s[a] : s[a].data)) {
                        rt.isArray(e) ? e = e.concat(rt.map(e, rt.camelCase)) : e in i ? e = [e] : (e = rt.camelCase(e), e = e in i ? [e] : e.split(" ")), r = e.length;
                        for (; r--;) delete i[e[r]];
                        if (n ? !u(i) : !rt.isEmptyObject(i)) return
                    }(n || (delete s[a].data, u(s[a]))) && (o ? rt.cleanData([t], !0) : nt.deleteExpando || s != s.window ? delete s[a] : s[a] = null)
                }
            }
        }

        function d() {
            return !0
        }

        function f() {
            return !1
        }

        function p() {
            try {
                return ht.activeElement
            } catch (t) {}
        }

        function m(t) {
            var e = It.split("|"),
                n = t.createDocumentFragment();
            if (n.createElement)
                for (; e.length;) n.createElement(e.pop());
            return n
        }

        function g(t, e) {
            var n, i, r = 0,
                o = typeof t.getElementsByTagName !== bt ? t.getElementsByTagName(e || "*") : typeof t.querySelectorAll !== bt ? t.querySelectorAll(e || "*") : void 0;
            if (!o)
                for (o = [], n = t.childNodes || t; null != (i = n[r]); r++) !e || rt.nodeName(i, e) ? o.push(i) : rt.merge(o, g(i, e));
            return void 0 === e || e && rt.nodeName(t, e) ? rt.merge([t], o) : o
        }

        function v(t) {
            Tt.test(t.type) && (t.defaultChecked = t.checked)
        }

        function y(t, e) {
            return rt.nodeName(t, "table") && rt.nodeName(11 !== e.nodeType ? e : e.firstChild, "tr") ? t.getElementsByTagName("tbody")[0] || t.appendChild(t.ownerDocument.createElement("tbody")) : t
        }

        function b(t) {
            return t.type = (null !== rt.find.attr(t, "type")) + "/" + t.type, t
        }

        function _(t) {
            var e = Ht.exec(t.type);
            return e ? t.type = e[1] : t.removeAttribute("type"), t
        }

        function w(t, e) {
            for (var n, i = 0; null != (n = t[i]); i++) rt._data(n, "globalEval", !e || rt._data(e[i], "globalEval"))
        }

        function x(t, e) {
            if (1 === e.nodeType && rt.hasData(t)) {
                var n, i, r, o = rt._data(t),
                    s = rt._data(e, o),
                    a = o.events;
                if (a) {
                    delete s.handle, s.events = {};
                    for (n in a)
                        for (i = 0, r = a[n].length; r > i; i++) rt.event.add(e, n, a[n][i])
                }
                s.data && (s.data = rt.extend({}, s.data))
            }
        }

        function k(t, e) {
            var n, i, r;
            if (1 === e.nodeType) {
                if (n = e.nodeName.toLowerCase(), !nt.noCloneEvent && e[rt.expando]) {
                    r = rt._data(e);
                    for (i in r.events) rt.removeEvent(e, i, r.handle);
                    e.removeAttribute(rt.expando)
                }
                "script" === n && e.text !== t.text ? (b(e).text = t.text, _(e)) : "object" === n ? (e.parentNode && (e.outerHTML = t.outerHTML), nt.html5Clone && t.innerHTML && !rt.trim(e.innerHTML) && (e.innerHTML = t.innerHTML)) : "input" === n && Tt.test(t.type) ? (e.defaultChecked = e.checked = t.checked, e.value !== t.value && (e.value = t.value)) : "option" === n ? e.defaultSelected = e.selected = t.defaultSelected : ("input" === n || "textarea" === n) && (e.defaultValue = t.defaultValue)
            }
        }

        function C(e, n) {
            var i, r = rt(n.createElement(e)).appendTo(n.body),
                o = t.getDefaultComputedStyle && (i = t.getDefaultComputedStyle(r[0])) ? i.display : rt.css(r[0], "display");
            return r.detach(), o
        }

        function E(t) {
            var e = ht,
                n = Zt[t];
            return n || (n = C(t, e), "none" !== n && n || (Vt = (Vt || rt("<iframe frameborder='0' width='0' height='0'/>")).appendTo(e.documentElement), e = (Vt[0].contentWindow || Vt[0].contentDocument).document, e.write(), e.close(), n = C(t, e), Vt.detach()), Zt[t] = n), n
        }

        function T(t, e) {
            return {
                get: function() {
                    var n = t();
                    if (null != n) return n ? void delete this.get : (this.get = e).apply(this, arguments)
                }
            }
        }

        function S(t, e) {
            if (e in t) return e;
            for (var n = e.charAt(0).toUpperCase() + e.slice(1), i = e, r = se.length; r--;)
                if ((e = se[r] + n) in t) return e;
            return i
        }

        function A(t, e) {
            for (var n, i, r, o = [], s = 0, a = t.length; a > s; s++) i = t[s], i.style && (o[s] = rt._data(i, "olddisplay"), n = i.style.display, e ? (o[s] || "none" !== n || (i.style.display = ""), "" === i.style.display && Ct(i) && (o[s] = rt._data(i, "olddisplay", E(i.nodeName)))) : (r = Ct(i), (n && "none" !== n || !r) && rt._data(i, "olddisplay", r ? n : rt.css(i, "display"))));
            for (s = 0; a > s; s++) i = t[s], i.style && (e && "none" !== i.style.display && "" !== i.style.display || (i.style.display = e ? o[s] || "" : "none"));
            return t
        }

        function N(t, e, n) {
            var i = ne.exec(e);
            return i ? Math.max(0, i[1] - (n || 0)) + (i[2] || "px") : e
        }

        function D(t, e, n, i, r) {
            for (var o = n === (i ? "border" : "content") ? 4 : "width" === e ? 1 : 0, s = 0; 4 > o; o += 2) "margin" === n && (s += rt.css(t, n + kt[o], !0, r)), i ? ("content" === n && (s -= rt.css(t, "padding" + kt[o], !0, r)), "margin" !== n && (s -= rt.css(t, "border" + kt[o] + "Width", !0, r))) : (s += rt.css(t, "padding" + kt[o], !0, r), "padding" !== n && (s += rt.css(t, "border" + kt[o] + "Width", !0, r)));
            return s
        }

        function O(t, e, n) {
            var i = !0,
                r = "width" === e ? t.offsetWidth : t.offsetHeight,
                o = Xt(t),
                s = nt.boxSizing && "border-box" === rt.css(t, "boxSizing", !1, o);
            if (0 >= r || null == r) {
                if (r = Gt(t, e, o), (0 > r || null == r) && (r = t.style[e]), Qt.test(r)) return r;
                i = s && (nt.boxSizingReliable() || r === t.style[e]), r = parseFloat(r) || 0
            }
            return r + D(t, e, n || (s ? "border" : "content"), i, o) + "px"
        }

        function I(t, e, n, i, r) {
            return new I.prototype.init(t, e, n, i, r)
        }

        function z() {
            return setTimeout(function() {
                ae = void 0
            }), ae = rt.now()
        }

        function L(t, e) {
            var n, i = {
                    height: t
                },
                r = 0;
            for (e = e ? 1 : 0; 4 > r; r += 2 - e) n = kt[r], i["margin" + n] = i["padding" + n] = t;
            return e && (i.opacity = i.width = t), i
        }

        function $(t, e, n) {
            for (var i, r = (fe[e] || []).concat(fe["*"]), o = 0, s = r.length; s > o; o++)
                if (i = r[o].call(n, e, t)) return i
        }

        function R(t, e, n) {
            var i, r, o, s, a, l, u, c = this,
                h = {},
                d = t.style,
                f = t.nodeType && Ct(t),
                p = rt._data(t, "fxshow");
            n.queue || (a = rt._queueHooks(t, "fx"), null == a.unqueued && (a.unqueued = 0, l = a.empty.fire, a.empty.fire = function() {
                a.unqueued || l()
            }), a.unqueued++, c.always(function() {
                c.always(function() {
                    a.unqueued--, rt.queue(t, "fx").length || a.empty.fire()
                })
            })), 1 === t.nodeType && ("height" in e || "width" in e) && (n.overflow = [d.overflow, d.overflowX, d.overflowY], u = rt.css(t, "display"), "inline" === ("none" === u ? rt._data(t, "olddisplay") || E(t.nodeName) : u) && "none" === rt.css(t, "float") && (nt.inlineBlockNeedsLayout && "inline" !== E(t.nodeName) ? d.zoom = 1 : d.display = "inline-block")), n.overflow && (d.overflow = "hidden", nt.shrinkWrapBlocks() || c.always(function() {
                d.overflow = n.overflow[0], d.overflowX = n.overflow[1], d.overflowY = n.overflow[2]
            }));
            for (i in e)
                if (r = e[i], ue.exec(r)) {
                    if (delete e[i], o = o || "toggle" === r, r === (f ? "hide" : "show")) {
                        if ("show" !== r || !p || void 0 === p[i]) continue;
                        f = !0
                    }
                    h[i] = p && p[i] || rt.style(t, i)
                } else u = void 0;
            if (rt.isEmptyObject(h)) "inline" === ("none" === u ? E(t.nodeName) : u) && (d.display = u);
            else {
                p ? "hidden" in p && (f = p.hidden) : p = rt._data(t, "fxshow", {}), o && (p.hidden = !f), f ? rt(t).show() : c.done(function() {
                    rt(t).hide()
                }), c.done(function() {
                    var e;
                    rt._removeData(t, "fxshow");
                    for (e in h) rt.style(t, e, h[e])
                });
                for (i in h) s = $(f ? p[i] : 0, i, c), i in p || (p[i] = s.start, f && (s.end = s.start, s.start = "width" === i || "height" === i ? 1 : 0))
            }
        }

        function P(t, e) {
            var n, i, r, o, s;
            for (n in t)
                if (i = rt.camelCase(n), r = e[i], o = t[n], rt.isArray(o) && (r = o[1], o = t[n] = o[0]), n !== i && (t[i] = o, delete t[n]), (s = rt.cssHooks[i]) && "expand" in s) {
                    o = s.expand(o), delete t[i];
                    for (n in o) n in t || (t[n] = o[n], e[n] = r)
                } else e[i] = r
        }

        function M(t, e, n) {
            var i, r, o = 0,
                s = de.length,
                a = rt.Deferred().always(function() {
                    delete l.elem
                }),
                l = function() {
                    if (r) return !1;
                    for (var e = ae || z(), n = Math.max(0, u.startTime + u.duration - e), i = n / u.duration || 0, o = 1 - i, s = 0, l = u.tweens.length; l > s; s++) u.tweens[s].run(o);
                    return a.notifyWith(t, [u, o, n]), 1 > o && l ? n : (a.resolveWith(t, [u]), !1)
                },
                u = a.promise({
                    elem: t,
                    props: rt.extend({}, e),
                    opts: rt.extend(!0, {
                        specialEasing: {}
                    }, n),
                    originalProperties: e,
                    originalOptions: n,
                    startTime: ae || z(),
                    duration: n.duration,
                    tweens: [],
                    createTween: function(e, n) {
                        var i = rt.Tween(t, u.opts, e, n, u.opts.specialEasing[e] || u.opts.easing);
                        return u.tweens.push(i), i
                    },
                    stop: function(e) {
                        var n = 0,
                            i = e ? u.tweens.length : 0;
                        if (r) return this;
                        for (r = !0; i > n; n++) u.tweens[n].run(1);
                        return e ? a.resolveWith(t, [u, e]) : a.rejectWith(t, [u, e]), this
                    }
                }),
                c = u.props;
            for (P(c, u.opts.specialEasing); s > o; o++)
                if (i = de[o].call(u, t, c, u.opts)) return i;
            return rt.map(c, $, u), rt.isFunction(u.opts.start) && u.opts.start.call(t, u), rt.fx.timer(rt.extend(l, {
                elem: t,
                anim: u,
                queue: u.opts.queue
            })), u.progress(u.opts.progress).done(u.opts.done, u.opts.complete).fail(u.opts.fail).always(u.opts.always)
        }

        function j(t) {
            return function(e, n) {
                "string" != typeof e && (n = e, e = "*");
                var i, r = 0,
                    o = e.toLowerCase().match(mt) || [];
                if (rt.isFunction(n))
                    for (; i = o[r++];) "+" === i.charAt(0) ? (i = i.slice(1) || "*", (t[i] = t[i] || []).unshift(n)) : (t[i] = t[i] || []).push(n)
            }
        }

        function F(t, e, n, i) {
            function r(a) {
                var l;
                return o[a] = !0, rt.each(t[a] || [], function(t, a) {
                    var u = a(e, n, i);
                    return "string" != typeof u || s || o[u] ? s ? !(l = u) : void 0 : (e.dataTypes.unshift(u), r(u), !1)
                }), l
            }
            var o = {},
                s = t === ze;
            return r(e.dataTypes[0]) || !o["*"] && r("*")
        }

        function B(t, e) {
            var n, i, r = rt.ajaxSettings.flatOptions || {};
            for (i in e) void 0 !== e[i] && ((r[i] ? t : n || (n = {}))[i] = e[i]);
            return n && rt.extend(!0, t, n), t
        }

        function H(t, e, n) {
            for (var i, r, o, s, a = t.contents, l = t.dataTypes;
                "*" === l[0];) l.shift(), void 0 === r && (r = t.mimeType || e.getResponseHeader("Content-Type"));
            if (r)
                for (s in a)
                    if (a[s] && a[s].test(r)) {
                        l.unshift(s);
                        break
                    } if (l[0] in n) o = l[0];
            else {
                for (s in n) {
                    if (!l[0] || t.converters[s + " " + l[0]]) {
                        o = s;
                        break
                    }
                    i || (i = s)
                }
                o = o || i
            }
            return o ? (o !== l[0] && l.unshift(o), n[o]) : void 0
        }

        function W(t, e, n, i) {
            var r, o, s, a, l, u = {},
                c = t.dataTypes.slice();
            if (c[1])
                for (s in t.converters) u[s.toLowerCase()] = t.converters[s];
            for (o = c.shift(); o;)
                if (t.responseFields[o] && (n[t.responseFields[o]] = e), !l && i && t.dataFilter && (e = t.dataFilter(e, t.dataType)), l = o, o = c.shift())
                    if ("*" === o) o = l;
                    else if ("*" !== l && l !== o) {
                if (!(s = u[l + " " + o] || u["* " + o]))
                    for (r in u)
                        if (a = r.split(" "), a[1] === o && (s = u[l + " " + a[0]] || u["* " + a[0]])) {
                            !0 === s ? s = u[r] : !0 !== u[r] && (o = a[0], c.unshift(a[1]));
                            break
                        } if (!0 !== s)
                    if (s && t.throws) e = s(e);
                    else try {
                        e = s(e)
                    } catch (t) {
                        return {
                            state: "parsererror",
                            error: s ? t : "No conversion from " + l + " to " + o
                        }
                    }
            }
            return {
                state: "success",
                data: e
            }
        }

        function U(t, e, n, i) {
            var r;
            if (rt.isArray(e)) rt.each(e, function(e, r) {
                n || $e.test(t) ? i(t, r) : U(t + "[" + ("object" == typeof r ? e : "") + "]", r, n, i)
            });
            else if (n || "object" !== rt.type(e)) i(t, e);
            else
                for (r in e) U(t + "[" + r + "]", e[r], n, i)
        }

        function q() {
            try {
                return new t.XMLHttpRequest
            } catch (t) {}
        }

        function V() {
            try {
                return new t.ActiveXObject("Microsoft.XMLHTTP")
            } catch (t) {}
        }

        function Z(t) {
            return rt.isWindow(t) ? t : 9 === t.nodeType && (t.defaultView || t.parentWindow)
        }
        var X = [],
            G = X.slice,
            K = X.concat,
            Q = X.push,
            Y = X.indexOf,
            J = {},
            tt = J.toString,
            et = J.hasOwnProperty,
            nt = {},
            it = "1.11.2",
            rt = function(t, e) {
                return new rt.fn.init(t, e)
            },
            ot = function(t, e) {
                return e.toUpperCase()
            };
        rt.fn = rt.prototype = {
            jquery: it,
            constructor: rt,
            selector: "",
            length: 0,
            toArray: function() {
                return G.call(this)
            },
            get: function(t) {
                return null != t ? 0 > t ? this[t + this.length] : this[t] : G.call(this)
            },
            pushStack: function(t) {
                var e = rt.merge(this.constructor(), t);
                return e.prevObject = this, e.context = this.context, e
            },
            each: function(t, e) {
                return rt.each(this, t, e)
            },
            map: function(t) {
                return this.pushStack(rt.map(this, function(e, n) {
                    return t.call(e, n, e)
                }))
            },
            slice: function() {
                return this.pushStack(G.apply(this, arguments))
            },
            first: function() {
                return this.eq(0)
            },
            last: function() {
                return this.eq(-1)
            },
            eq: function(t) {
                var e = this.length,
                    n = +t + (0 > t ? e : 0);
                return this.pushStack(n >= 0 && e > n ? [this[n]] : [])
            },
            end: function() {
                return this.prevObject || this.constructor(null)
            },
            push: Q,
            sort: X.sort,
            splice: X.splice
        }, rt.extend = rt.fn.extend = function() {
            var t, e, n, i, r, o, s = arguments[0] || {},
                a = 1,
                l = arguments.length,
                u = !1;
            for ("boolean" == typeof s && (u = s, s = arguments[a] || {}, a++), "object" == typeof s || rt.isFunction(s) || (s = {}), a === l && (s = this, a--); l > a; a++)
                if (null != (r = arguments[a]))
                    for (i in r) t = s[i], n = r[i], s !== n && (u && n && (rt.isPlainObject(n) || (e = rt.isArray(n))) ? (e ? (e = !1, o = t && rt.isArray(t) ? t : []) : o = t && rt.isPlainObject(t) ? t : {}, s[i] = rt.extend(u, o, n)) : void 0 !== n && (s[i] = n));
            return s
        }, rt.extend({
            expando: "jQuery" + (it + Math.random()).replace(/\D/g, ""),
            isReady: !0,
            error: function(t) {
                throw new Error(t)
            },
            noop: function() {},
            isFunction: function(t) {
                return "function" === rt.type(t)
            },
            isArray: Array.isArray || function(t) {
                return "array" === rt.type(t)
            },
            isWindow: function(t) {
                return null != t && t == t.window
            },
            isNumeric: function(t) {
                return !rt.isArray(t) && t - parseFloat(t) + 1 >= 0
            },
            isEmptyObject: function(t) {
                var e;
                for (e in t) return !1;
                return !0
            },
            isPlainObject: function(t) {
                var e;
                if (!t || "object" !== rt.type(t) || t.nodeType || rt.isWindow(t)) return !1;
                try {
                    if (t.constructor && !et.call(t, "constructor") && !et.call(t.constructor.prototype, "isPrototypeOf")) return !1
                } catch (t) {
                    return !1
                }
                if (nt.ownLast)
                    for (e in t) return et.call(t, e);
                for (e in t);
                return void 0 === e || et.call(t, e)
            },
            type: function(t) {
                return null == t ? t + "" : "object" == typeof t || "function" == typeof t ? J[tt.call(t)] || "object" : typeof t
            },
            globalEval: function(e) {
                e && rt.trim(e) && (t.execScript || function(e) {
                    t.eval.call(t, e)
                })(e)
            },
            camelCase: function(t) {
                return t.replace(/^-ms-/, "ms-").replace(/-([\da-z])/gi, ot)
            },
            nodeName: function(t, e) {
                return t.nodeName && t.nodeName.toLowerCase() === e.toLowerCase()
            },
            each: function(t, e, i) {
                var r = 0,
                    o = t.length,
                    s = n(t);
                if (i) {
                    if (s)
                        for (; o > r && !1 !== e.apply(t[r], i); r++);
                    else
                        for (r in t)
                            if (!1 === e.apply(t[r], i)) break
                } else if (s)
                    for (; o > r && !1 !== e.call(t[r], r, t[r]); r++);
                else
                    for (r in t)
                        if (!1 === e.call(t[r], r, t[r])) break;
                return t
            },
            trim: function(t) {
                return null == t ? "" : (t + "").replace(/^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g, "")
            },
            makeArray: function(t, e) {
                var i = e || [];
                return null != t && (n(Object(t)) ? rt.merge(i, "string" == typeof t ? [t] : t) : Q.call(i, t)), i
            },
            inArray: function(t, e, n) {
                var i;
                if (e) {
                    if (Y) return Y.call(e, t, n);
                    for (i = e.length, n = n ? 0 > n ? Math.max(0, i + n) : n : 0; i > n; n++)
                        if (n in e && e[n] === t) return n
                }
                return -1
            },
            merge: function(t, e) {
                for (var n = +e.length, i = 0, r = t.length; n > i;) t[r++] = e[i++];
                if (n !== n)
                    for (; void 0 !== e[i];) t[r++] = e[i++];
                return t.length = r, t
            },
            grep: function(t, e, n) {
                for (var i = [], r = 0, o = t.length, s = !n; o > r; r++) !e(t[r], r) !== s && i.push(t[r]);
                return i
            },
            map: function(t, e, i) {
                var r, o = 0,
                    s = t.length,
                    a = n(t),
                    l = [];
                if (a)
                    for (; s > o; o++) null != (r = e(t[o], o, i)) && l.push(r);
                else
                    for (o in t) null != (r = e(t[o], o, i)) && l.push(r);
                return K.apply([], l)
            },
            guid: 1,
            proxy: function(t, e) {
                var n, i, r;
                return "string" == typeof e && (r = t[e], e = t, t = r), rt.isFunction(t) ? (n = G.call(arguments, 2), i = function() {
                    return t.apply(e || this, n.concat(G.call(arguments)))
                }, i.guid = t.guid = t.guid || rt.guid++, i) : void 0
            },
            now: function() {
                return +new Date
            },
            support: nt
        }), rt.each("Boolean Number String Function Array Date RegExp Object Error".split(" "), function(t, e) {
            J["[object " + e + "]"] = e.toLowerCase()
        });
        var st = function(t) {
            function e(t, e, n, i) {
                var r, o, s, a, u, h, d, f, p, m;
                if ((e ? e.ownerDocument || e : M) !== D && N(e), e = e || D, n = n || [], a = e.nodeType, "string" != typeof t || !t || 1 !== a && 9 !== a && 11 !== a) return n;
                if (!i && I) {
                    if (11 !== a && (r = gt.exec(t)))
                        if (s = r[1]) {
                            if (9 === a) {
                                if (!(o = e.getElementById(s)) || !o.parentNode) return n;
                                if (o.id === s) return n.push(o), n
                            } else if (e.ownerDocument && (o = e.ownerDocument.getElementById(s)) && R(e, o) && o.id === s) return n.push(o), n
                        } else {
                            if (r[2]) return K.apply(n, e.getElementsByTagName(t)), n;
                            if ((s = r[3]) && b.getElementsByClassName) return K.apply(n, e.getElementsByClassName(s)), n
                        } if (b.qsa && (!z || !z.test(t))) {
                        if (f = d = P, p = e, m = 1 !== a && t, 1 === a && "object" !== e.nodeName.toLowerCase()) {
                            for (h = k(t), (d = e.getAttribute("id")) ? f = d.replace(yt, "\\$&") : e.setAttribute("id", f), f = "[id='" + f + "'] ", u = h.length; u--;) h[u] = f + c(h[u]);
                            p = vt.test(t) && l(e.parentNode) || e, m = h.join(",")
                        }
                        if (m) try {
                            return K.apply(n, p.querySelectorAll(m)), n
                        } catch (t) {} finally {
                            d || e.removeAttribute("id")
                        }
                    }
                }
                return E(t.replace(st, "$1"), e, n, i)
            }

            function n() {
                function t(n, i) {
                    return e.push(n + " ") > _.cacheLength && delete t[e.shift()], t[n + " "] = i
                }
                var e = [];
                return t
            }

            function i(t) {
                return t[P] = !0, t
            }

            function r(t) {
                var e = D.createElement("div");
                try {
                    return !!t(e)
                } catch (t) {
                    return !1
                } finally {
                    e.parentNode && e.parentNode.removeChild(e), e = null
                }
            }

            function o(t, e) {
                for (var n = t.split("|"), i = t.length; i--;) _.attrHandle[n[i]] = e
            }

            function s(t, e) {
                var n = e && t,
                    i = n && 1 === t.nodeType && 1 === e.nodeType && (~e.sourceIndex || q) - (~t.sourceIndex || q);
                if (i) return i;
                if (n)
                    for (; n = n.nextSibling;)
                        if (n === e) return -1;
                return t ? 1 : -1
            }

            function a(t) {
                return i(function(e) {
                    return e = +e, i(function(n, i) {
                        for (var r, o = t([], n.length, e), s = o.length; s--;) n[r = o[s]] && (n[r] = !(i[r] = n[r]))
                    })
                })
            }

            function l(t) {
                return t && void 0 !== t.getElementsByTagName && t
            }

            function u() {}

            function c(t) {
                for (var e = 0, n = t.length, i = ""; n > e; e++) i += t[e].value;
                return i
            }

            function h(t, e, n) {
                var i = e.dir,
                    r = n && "parentNode" === i,
                    o = F++;
                return e.first ? function(e, n, o) {
                    for (; e = e[i];)
                        if (1 === e.nodeType || r) return t(e, n, o)
                } : function(e, n, s) {
                    var a, l, u = [j, o];
                    if (s) {
                        for (; e = e[i];)
                            if ((1 === e.nodeType || r) && t(e, n, s)) return !0
                    } else
                        for (; e = e[i];)
                            if (1 === e.nodeType || r) {
                                if (l = e[P] || (e[P] = {}), (a = l[i]) && a[0] === j && a[1] === o) return u[2] = a[2];
                                if (l[i] = u, u[2] = t(e, n, s)) return !0
                            }
                }
            }

            function d(t) {
                return t.length > 1 ? function(e, n, i) {
                    for (var r = t.length; r--;)
                        if (!t[r](e, n, i)) return !1;
                    return !0
                } : t[0]
            }

            function f(t, n, i) {
                for (var r = 0, o = n.length; o > r; r++) e(t, n[r], i);
                return i
            }

            function p(t, e, n, i, r) {
                for (var o, s = [], a = 0, l = t.length, u = null != e; l > a; a++)(o = t[a]) && (!n || n(o, i, r)) && (s.push(o), u && e.push(a));
                return s
            }

            function m(t, e, n, r, o, s) {
                return r && !r[P] && (r = m(r)), o && !o[P] && (o = m(o, s)), i(function(i, s, a, l) {
                    var u, c, h, d = [],
                        m = [],
                        g = s.length,
                        v = i || f(e || "*", a.nodeType ? [a] : a, []),
                        y = !t || !i && e ? v : p(v, d, t, a, l),
                        b = n ? o || (i ? t : g || r) ? [] : s : y;
                    if (n && n(y, b, a, l), r)
                        for (u = p(b, m), r(u, [], a, l), c = u.length; c--;)(h = u[c]) && (b[m[c]] = !(y[m[c]] = h));
                    if (i) {
                        if (o || t) {
                            if (o) {
                                for (u = [], c = b.length; c--;)(h = b[c]) && u.push(y[c] = h);
                                o(null, b = [], u, l)
                            }
                            for (c = b.length; c--;)(h = b[c]) && (u = o ? Y(i, h) : d[c]) > -1 && (i[u] = !(s[u] = h))
                        }
                    } else b = p(b === s ? b.splice(g, b.length) : b), o ? o(null, s, b, l) : K.apply(s, b)
                })
            }

            function g(t) {
                for (var e, n, i, r = t.length, o = _.relative[t[0].type], s = o || _.relative[" "], a = o ? 1 : 0, l = h(function(t) {
                        return t === e
                    }, s, !0), u = h(function(t) {
                        return Y(e, t) > -1
                    }, s, !0), f = [function(t, n, i) {
                        var r = !o && (i || n !== T) || ((e = n).nodeType ? l(t, n, i) : u(t, n, i));
                        return e = null, r
                    }]; r > a; a++)
                    if (n = _.relative[t[a].type]) f = [h(d(f), n)];
                    else {
                        if (n = _.filter[t[a].type].apply(null, t[a].matches), n[P]) {
                            for (i = ++a; r > i && !_.relative[t[i].type]; i++);
                            return m(a > 1 && d(f), a > 1 && c(t.slice(0, a - 1).concat({
                                value: " " === t[a - 2].type ? "*" : ""
                            })).replace(st, "$1"), n, i > a && g(t.slice(a, i)), r > i && g(t = t.slice(i)), r > i && c(t))
                        }
                        f.push(n)
                    } return d(f)
            }

            function v(t, n) {
                var r = n.length > 0,
                    o = t.length > 0,
                    s = function(i, s, a, l, u) {
                        var c, h, d, f = 0,
                            m = "0",
                            g = i && [],
                            v = [],
                            y = T,
                            b = i || o && _.find.TAG("*", u),
                            w = j += null == y ? 1 : Math.random() || .1,
                            x = b.length;
                        for (u && (T = s !== D && s); m !== x && null != (c = b[m]); m++) {
                            if (o && c) {
                                for (h = 0; d = t[h++];)
                                    if (d(c, s, a)) {
                                        l.push(c);
                                        break
                                    } u && (j = w)
                            }
                            r && ((c = !d && c) && f--, i && g.push(c))
                        }
                        if (f += m, r && m !== f) {
                            for (h = 0; d = n[h++];) d(g, v, s, a);
                            if (i) {
                                if (f > 0)
                                    for (; m--;) g[m] || v[m] || (v[m] = X.call(l));
                                v = p(v)
                            }
                            K.apply(l, v), u && !i && v.length > 0 && f + n.length > 1 && e.uniqueSort(l)
                        }
                        return u && (j = w, T = y), g
                    };
                return r ? i(s) : s
            }
            var y, b, _, w, x, k, C, E, T, S, A, N, D, O, I, z, L, $, R, P = "sizzle" + 1 * new Date,
                M = t.document,
                j = 0,
                F = 0,
                B = n(),
                H = n(),
                W = n(),
                U = function(t, e) {
                    return t === e && (A = !0), 0
                },
                q = 1 << 31,
                V = {}.hasOwnProperty,
                Z = [],
                X = Z.pop,
                G = Z.push,
                K = Z.push,
                Q = Z.slice,
                Y = function(t, e) {
                    for (var n = 0, i = t.length; i > n; n++)
                        if (t[n] === e) return n;
                    return -1
                },
                J = "checked|selected|async|autofocus|autoplay|controls|defer|disabled|hidden|ismap|loop|multiple|open|readonly|required|scoped",
                tt = "[\\x20\\t\\r\\n\\f]",
                et = "(?:\\\\.|[\\w-]|[^\\x00-\\xa0])+",
                nt = et.replace("w", "w#"),
                it = "\\[" + tt + "*(" + et + ")(?:" + tt + "*([*^$|!~]?=)" + tt + "*(?:'((?:\\\\.|[^\\\\'])*)'|\"((?:\\\\.|[^\\\\\"])*)\"|(" + nt + "))|)" + tt + "*\\]",
                rt = ":(" + et + ")(?:\\((('((?:\\\\.|[^\\\\'])*)'|\"((?:\\\\.|[^\\\\\"])*)\")|((?:\\\\.|[^\\\\()[\\]]|" + it + ")*)|.*)\\)|)",
                ot = new RegExp(tt + "+", "g"),
                st = new RegExp("^" + tt + "+|((?:^|[^\\\\])(?:\\\\.)*)" + tt + "+$", "g"),
                at = new RegExp("^" + tt + "*," + tt + "*"),
                lt = new RegExp("^" + tt + "*([>+~]|" + tt + ")" + tt + "*"),
                ut = new RegExp("=" + tt + "*([^\\]'\"]*?)" + tt + "*\\]", "g"),
                ct = new RegExp(rt),
                ht = new RegExp("^" + nt + "$"),
                dt = {
                    ID: new RegExp("^#(" + et + ")"),
                    CLASS: new RegExp("^\\.(" + et + ")"),
                    TAG: new RegExp("^(" + et.replace("w", "w*") + ")"),
                    ATTR: new RegExp("^" + it),
                    PSEUDO: new RegExp("^" + rt),
                    CHILD: new RegExp("^:(only|first|last|nth|nth-last)-(child|of-type)(?:\\(" + tt + "*(even|odd|(([+-]|)(\\d*)n|)" + tt + "*(?:([+-]|)" + tt + "*(\\d+)|))" + tt + "*\\)|)", "i"),
                    bool: new RegExp("^(?:" + J + ")$", "i"),
                    needsContext: new RegExp("^" + tt + "*[>+~]|:(even|odd|eq|gt|lt|nth|first|last)(?:\\(" + tt + "*((?:-\\d)?\\d*)" + tt + "*\\)|)(?=[^-]|$)", "i")
                },
                ft = /^(?:input|select|textarea|button)$/i,
                pt = /^h\d$/i,
                mt = /^[^{]+\{\s*\[native \w/,
                gt = /^(?:#([\w-]+)|(\w+)|\.([\w-]+))$/,
                vt = /[+~]/,
                yt = /'|\\/g,
                bt = new RegExp("\\\\([\\da-f]{1,6}" + tt + "?|(" + tt + ")|.)", "ig"),
                _t = function(t, e, n) {
                    var i = "0x" + e - 65536;
                    return i !== i || n ? e : 0 > i ? String.fromCharCode(i + 65536) : String.fromCharCode(i >> 10 | 55296, 1023 & i | 56320)
                },
                wt = function() {
                    N()
                };
            try {
                K.apply(Z = Q.call(M.childNodes), M.childNodes), Z[M.childNodes.length].nodeType
            } catch (t) {
                K = {
                    apply: Z.length ? function(t, e) {
                        G.apply(t, Q.call(e))
                    } : function(t, e) {
                        for (var n = t.length, i = 0; t[n++] = e[i++];);
                        t.length = n - 1
                    }
                }
            }
            b = e.support = {}, x = e.isXML = function(t) {
                var e = t && (t.ownerDocument || t).documentElement;
                return !!e && "HTML" !== e.nodeName
            }, N = e.setDocument = function(t) {
                var e, n, i = t ? t.ownerDocument || t : M;
                return i !== D && 9 === i.nodeType && i.documentElement ? (D = i, O = i.documentElement, n = i.defaultView, n && n !== n.top && (n.addEventListener ? n.addEventListener("unload", wt, !1) : n.attachEvent && n.attachEvent("onunload", wt)), I = !x(i), b.attributes = r(function(t) {
                    return t.className = "i", !t.getAttribute("className")
                }), b.getElementsByTagName = r(function(t) {
                    return t.appendChild(i.createComment("")), !t.getElementsByTagName("*").length
                }), b.getElementsByClassName = mt.test(i.getElementsByClassName), b.getById = r(function(t) {
                    return O.appendChild(t).id = P, !i.getElementsByName || !i.getElementsByName(P).length
                }), b.getById ? (_.find.ID = function(t, e) {
                    if (void 0 !== e.getElementById && I) {
                        var n = e.getElementById(t);
                        return n && n.parentNode ? [n] : []
                    }
                }, _.filter.ID = function(t) {
                    var e = t.replace(bt, _t);
                    return function(t) {
                        return t.getAttribute("id") === e
                    }
                }) : (delete _.find.ID, _.filter.ID = function(t) {
                    var e = t.replace(bt, _t);
                    return function(t) {
                        var n = void 0 !== t.getAttributeNode && t.getAttributeNode("id");
                        return n && n.value === e
                    }
                }), _.find.TAG = b.getElementsByTagName ? function(t, e) {
                    return void 0 !== e.getElementsByTagName ? e.getElementsByTagName(t) : b.qsa ? e.querySelectorAll(t) : void 0
                } : function(t, e) {
                    var n, i = [],
                        r = 0,
                        o = e.getElementsByTagName(t);
                    if ("*" === t) {
                        for (; n = o[r++];) 1 === n.nodeType && i.push(n);
                        return i
                    }
                    return o
                }, _.find.CLASS = b.getElementsByClassName && function(t, e) {
                    return I ? e.getElementsByClassName(t) : void 0
                }, L = [], z = [], (b.qsa = mt.test(i.querySelectorAll)) && (r(function(t) {
                    O.appendChild(t).innerHTML = "<a id='" + P + "'></a><select id='" + P + "-\f]' msallowcapture=''><option selected=''></option></select>", t.querySelectorAll("[msallowcapture^='']").length && z.push("[*^$]=" + tt + "*(?:''|\"\")"), t.querySelectorAll("[selected]").length || z.push("\\[" + tt + "*(?:value|" + J + ")"), t.querySelectorAll("[id~=" + P + "-]").length || z.push("~="), t.querySelectorAll(":checked").length || z.push(":checked"), t.querySelectorAll("a#" + P + "+*").length || z.push(".#.+[+~]")
                }), r(function(t) {
                    var e = i.createElement("input");
                    e.setAttribute("type", "hidden"), t.appendChild(e).setAttribute("name", "D"), t.querySelectorAll("[name=d]").length && z.push("name" + tt + "*[*^$|!~]?="), t.querySelectorAll(":enabled").length || z.push(":enabled", ":disabled"), t.querySelectorAll("*,:x"), z.push(",.*:")
                })), (b.matchesSelector = mt.test($ = O.matches || O.webkitMatchesSelector || O.mozMatchesSelector || O.oMatchesSelector || O.msMatchesSelector)) && r(function(t) {
                    b.disconnectedMatch = $.call(t, "div"), $.call(t, "[s!='']:x"), L.push("!=", rt)
                }), z = z.length && new RegExp(z.join("|")), L = L.length && new RegExp(L.join("|")), e = mt.test(O.compareDocumentPosition), R = e || mt.test(O.contains) ? function(t, e) {
                    var n = 9 === t.nodeType ? t.documentElement : t,
                        i = e && e.parentNode;
                    return t === i || !(!i || 1 !== i.nodeType || !(n.contains ? n.contains(i) : t.compareDocumentPosition && 16 & t.compareDocumentPosition(i)))
                } : function(t, e) {
                    if (e)
                        for (; e = e.parentNode;)
                            if (e === t) return !0;
                    return !1
                }, U = e ? function(t, e) {
                    if (t === e) return A = !0, 0;
                    var n = !t.compareDocumentPosition - !e.compareDocumentPosition;
                    return n || (n = (t.ownerDocument || t) === (e.ownerDocument || e) ? t.compareDocumentPosition(e) : 1, 1 & n || !b.sortDetached && e.compareDocumentPosition(t) === n ? t === i || t.ownerDocument === M && R(M, t) ? -1 : e === i || e.ownerDocument === M && R(M, e) ? 1 : S ? Y(S, t) - Y(S, e) : 0 : 4 & n ? -1 : 1)
                } : function(t, e) {
                    if (t === e) return A = !0, 0;
                    var n, r = 0,
                        o = t.parentNode,
                        a = e.parentNode,
                        l = [t],
                        u = [e];
                    if (!o || !a) return t === i ? -1 : e === i ? 1 : o ? -1 : a ? 1 : S ? Y(S, t) - Y(S, e) : 0;
                    if (o === a) return s(t, e);
                    for (n = t; n = n.parentNode;) l.unshift(n);
                    for (n = e; n = n.parentNode;) u.unshift(n);
                    for (; l[r] === u[r];) r++;
                    return r ? s(l[r], u[r]) : l[r] === M ? -1 : u[r] === M ? 1 : 0
                }, i) : D
            }, e.matches = function(t, n) {
                return e(t, null, null, n)
            }, e.matchesSelector = function(t, n) {
                if ((t.ownerDocument || t) !== D && N(t), n = n.replace(ut, "='$1']"), !(!b.matchesSelector || !I || L && L.test(n) || z && z.test(n))) try {
                    var i = $.call(t, n);
                    if (i || b.disconnectedMatch || t.document && 11 !== t.document.nodeType) return i
                } catch (t) {}
                return e(n, D, null, [t]).length > 0
            }, e.contains = function(t, e) {
                return (t.ownerDocument || t) !== D && N(t), R(t, e)
            }, e.attr = function(t, e) {
                (t.ownerDocument || t) !== D && N(t);
                var n = _.attrHandle[e.toLowerCase()],
                    i = n && V.call(_.attrHandle, e.toLowerCase()) ? n(t, e, !I) : void 0;
                return void 0 !== i ? i : b.attributes || !I ? t.getAttribute(e) : (i = t.getAttributeNode(e)) && i.specified ? i.value : null
            }, e.error = function(t) {
                throw new Error("Syntax error, unrecognized expression: " + t)
            }, e.uniqueSort = function(t) {
                var e, n = [],
                    i = 0,
                    r = 0;
                if (A = !b.detectDuplicates, S = !b.sortStable && t.slice(0), t.sort(U), A) {
                    for (; e = t[r++];) e === t[r] && (i = n.push(r));
                    for (; i--;) t.splice(n[i], 1)
                }
                return S = null, t
            }, w = e.getText = function(t) {
                var e, n = "",
                    i = 0,
                    r = t.nodeType;
                if (r) {
                    if (1 === r || 9 === r || 11 === r) {
                        if ("string" == typeof t.textContent) return t.textContent;
                        for (t = t.firstChild; t; t = t.nextSibling) n += w(t)
                    } else if (3 === r || 4 === r) return t.nodeValue
                } else
                    for (; e = t[i++];) n += w(e);
                return n
            }, _ = e.selectors = {
                cacheLength: 50,
                createPseudo: i,
                match: dt,
                attrHandle: {},
                find: {},
                relative: {
                    ">": {
                        dir: "parentNode",
                        first: !0
                    },
                    " ": {
                        dir: "parentNode"
                    },
                    "+": {
                        dir: "previousSibling",
                        first: !0
                    },
                    "~": {
                        dir: "previousSibling"
                    }
                },
                preFilter: {
                    ATTR: function(t) {
                        return t[1] = t[1].replace(bt, _t), t[3] = (t[3] || t[4] || t[5] || "").replace(bt, _t), "~=" === t[2] && (t[3] = " " + t[3] + " "), t.slice(0, 4)
                    },
                    CHILD: function(t) {
                        return t[1] = t[1].toLowerCase(), "nth" === t[1].slice(0, 3) ? (t[3] || e.error(t[0]), t[4] = +(t[4] ? t[5] + (t[6] || 1) : 2 * ("even" === t[3] || "odd" === t[3])), t[5] = +(t[7] + t[8] || "odd" === t[3])) : t[3] && e.error(t[0]), t
                    },
                    PSEUDO: function(t) {
                        var e, n = !t[6] && t[2];
                        return dt.CHILD.test(t[0]) ? null : (t[3] ? t[2] = t[4] || t[5] || "" : n && ct.test(n) && (e = k(n, !0)) && (e = n.indexOf(")", n.length - e) - n.length) && (t[0] = t[0].slice(0, e), t[2] = n.slice(0, e)), t.slice(0, 3))
                    }
                },
                filter: {
                    TAG: function(t) {
                        var e = t.replace(bt, _t).toLowerCase();
                        return "*" === t ? function() {
                            return !0
                        } : function(t) {
                            return t.nodeName && t.nodeName.toLowerCase() === e
                        }
                    },
                    CLASS: function(t) {
                        var e = B[t + " "];
                        return e || (e = new RegExp("(^|" + tt + ")" + t + "(" + tt + "|$)")) && B(t, function(t) {
                            return e.test("string" == typeof t.className && t.className || void 0 !== t.getAttribute && t.getAttribute("class") || "")
                        })
                    },
                    ATTR: function(t, n, i) {
                        return function(r) {
                            var o = e.attr(r, t);
                            return null == o ? "!=" === n : !n || (o += "", "=" === n ? o === i : "!=" === n ? o !== i : "^=" === n ? i && 0 === o.indexOf(i) : "*=" === n ? i && o.indexOf(i) > -1 : "$=" === n ? i && o.slice(-i.length) === i : "~=" === n ? (" " + o.replace(ot, " ") + " ").indexOf(i) > -1 : "|=" === n && (o === i || o.slice(0, i.length + 1) === i + "-"))
                        }
                    },
                    CHILD: function(t, e, n, i, r) {
                        var o = "nth" !== t.slice(0, 3),
                            s = "last" !== t.slice(-4),
                            a = "of-type" === e;
                        return 1 === i && 0 === r ? function(t) {
                            return !!t.parentNode
                        } : function(e, n, l) {
                            var u, c, h, d, f, p, m = o !== s ? "nextSibling" : "previousSibling",
                                g = e.parentNode,
                                v = a && e.nodeName.toLowerCase(),
                                y = !l && !a;
                            if (g) {
                                if (o) {
                                    for (; m;) {
                                        for (h = e; h = h[m];)
                                            if (a ? h.nodeName.toLowerCase() === v : 1 === h.nodeType) return !1;
                                        p = m = "only" === t && !p && "nextSibling"
                                    }
                                    return !0
                                }
                                if (p = [s ? g.firstChild : g.lastChild], s && y) {
                                    for (c = g[P] || (g[P] = {}), u = c[t] || [], f = u[0] === j && u[1], d = u[0] === j && u[2], h = f && g.childNodes[f]; h = ++f && h && h[m] || (d = f = 0) || p.pop();)
                                        if (1 === h.nodeType && ++d && h === e) {
                                            c[t] = [j, f, d];
                                            break
                                        }
                                } else if (y && (u = (e[P] || (e[P] = {}))[t]) && u[0] === j) d = u[1];
                                else
                                    for (;
                                        (h = ++f && h && h[m] || (d = f = 0) || p.pop()) && ((a ? h.nodeName.toLowerCase() !== v : 1 !== h.nodeType) || !++d || (y && ((h[P] || (h[P] = {}))[t] = [j, d]), h !== e)););
                                return (d -= r) === i || d % i == 0 && d / i >= 0
                            }
                        }
                    },
                    PSEUDO: function(t, n) {
                        var r, o = _.pseudos[t] || _.setFilters[t.toLowerCase()] || e.error("unsupported pseudo: " + t);
                        return o[P] ? o(n) : o.length > 1 ? (r = [t, t, "", n], _.setFilters.hasOwnProperty(t.toLowerCase()) ? i(function(t, e) {
                            for (var i, r = o(t, n), s = r.length; s--;) i = Y(t, r[s]), t[i] = !(e[i] = r[s])
                        }) : function(t) {
                            return o(t, 0, r)
                        }) : o
                    }
                },
                pseudos: {
                    not: i(function(t) {
                        var e = [],
                            n = [],
                            r = C(t.replace(st, "$1"));
                        return r[P] ? i(function(t, e, n, i) {
                            for (var o, s = r(t, null, i, []), a = t.length; a--;)(o = s[a]) && (t[a] = !(e[a] = o))
                        }) : function(t, i, o) {
                            return e[0] = t, r(e, null, o, n), e[0] = null, !n.pop()
                        }
                    }),
                    has: i(function(t) {
                        return function(n) {
                            return e(t, n).length > 0
                        }
                    }),
                    contains: i(function(t) {
                        return t = t.replace(bt, _t),
                            function(e) {
                                return (e.textContent || e.innerText || w(e)).indexOf(t) > -1
                            }
                    }),
                    lang: i(function(t) {
                        return ht.test(t || "") || e.error("unsupported lang: " + t), t = t.replace(bt, _t).toLowerCase(),
                            function(e) {
                                var n;
                                do {
                                    if (n = I ? e.lang : e.getAttribute("xml:lang") || e.getAttribute("lang")) return (n = n.toLowerCase()) === t || 0 === n.indexOf(t + "-")
                                } while ((e = e.parentNode) && 1 === e.nodeType);
                                return !1
                            }
                    }),
                    target: function(e) {
                        var n = t.location && t.location.hash;
                        return n && n.slice(1) === e.id
                    },
                    root: function(t) {
                        return t === O
                    },
                    focus: function(t) {
                        return t === D.activeElement && (!D.hasFocus || D.hasFocus()) && !!(t.type || t.href || ~t.tabIndex)
                    },
                    enabled: function(t) {
                        return !1 === t.disabled
                    },
                    disabled: function(t) {
                        return !0 === t.disabled
                    },
                    checked: function(t) {
                        var e = t.nodeName.toLowerCase();
                        return "input" === e && !!t.checked || "option" === e && !!t.selected
                    },
                    selected: function(t) {
                        return t.parentNode && t.parentNode.selectedIndex, !0 === t.selected
                    },
                    empty: function(t) {
                        for (t = t.firstChild; t; t = t.nextSibling)
                            if (t.nodeType < 6) return !1;
                        return !0
                    },
                    parent: function(t) {
                        return !_.pseudos.empty(t)
                    },
                    header: function(t) {
                        return pt.test(t.nodeName)
                    },
                    input: function(t) {
                        return ft.test(t.nodeName)
                    },
                    button: function(t) {
                        var e = t.nodeName.toLowerCase();
                        return "input" === e && "button" === t.type || "button" === e
                    },
                    text: function(t) {
                        var e;
                        return "input" === t.nodeName.toLowerCase() && "text" === t.type && (null == (e = t.getAttribute("type")) || "text" === e.toLowerCase())
                    },
                    first: a(function() {
                        return [0]
                    }),
                    last: a(function(t, e) {
                        return [e - 1]
                    }),
                    eq: a(function(t, e, n) {
                        return [0 > n ? n + e : n]
                    }),
                    even: a(function(t, e) {
                        for (var n = 0; e > n; n += 2) t.push(n);
                        return t
                    }),
                    odd: a(function(t, e) {
                        for (var n = 1; e > n; n += 2) t.push(n);
                        return t
                    }),
                    lt: a(function(t, e, n) {
                        for (var i = 0 > n ? n + e : n; --i >= 0;) t.push(i);
                        return t
                    }),
                    gt: a(function(t, e, n) {
                        for (var i = 0 > n ? n + e : n; ++i < e;) t.push(i);
                        return t
                    })
                }
            }, _.pseudos.nth = _.pseudos.eq;
            for (y in {
                    radio: !0,
                    checkbox: !0,
                    file: !0,
                    password: !0,
                    image: !0
                }) _.pseudos[y] = function(t) {
                return function(e) {
                    return "input" === e.nodeName.toLowerCase() && e.type === t
                }
            }(y);
            for (y in {
                    submit: !0,
                    reset: !0
                }) _.pseudos[y] = function(t) {
                return function(e) {
                    var n = e.nodeName.toLowerCase();
                    return ("input" === n || "button" === n) && e.type === t
                }
            }(y);
            return u.prototype = _.filters = _.pseudos, _.setFilters = new u, k = e.tokenize = function(t, n) {
                    var i, r, o, s, a, l, u, c = H[t + " "];
                    if (c) return n ? 0 : c.slice(0);
                    for (a = t, l = [], u = _.preFilter; a;) {
                        (!i || (r = at.exec(a))) && (r && (a = a.slice(r[0].length) || a), l.push(o = [])), i = !1, (r = lt.exec(a)) && (i = r.shift(), o.push({
                            value: i,
                            type: r[0].replace(st, " ")
                        }), a = a.slice(i.length));
                        for (s in _.filter) !(r = dt[s].exec(a)) || u[s] && !(r = u[s](r)) || (i = r.shift(), o.push({
                            value: i,
                            type: s,
                            matches: r
                        }), a = a.slice(i.length));
                        if (!i) break
                    }
                    return n ? a.length : a ? e.error(t) : H(t, l).slice(0)
                },
                C = e.compile = function(t, e) {
                    var n, i = [],
                        r = [],
                        o = W[t + " "];
                    if (!o) {
                        for (e || (e = k(t)), n = e.length; n--;) o = g(e[n]), o[P] ? i.push(o) : r.push(o);
                        o = W(t, v(r, i)), o.selector = t
                    }
                    return o
                }, E = e.select = function(t, e, n, i) {
                    var r, o, s, a, u, h = "function" == typeof t && t,
                        d = !i && k(t = h.selector || t);
                    if (n = n || [], 1 === d.length) {
                        if (o = d[0] = d[0].slice(0), o.length > 2 && "ID" === (s = o[0]).type && b.getById && 9 === e.nodeType && I && _.relative[o[1].type]) {
                            if (!(e = (_.find.ID(s.matches[0].replace(bt, _t), e) || [])[0])) return n;
                            h && (e = e.parentNode), t = t.slice(o.shift().value.length)
                        }
                        for (r = dt.needsContext.test(t) ? 0 : o.length; r-- && (s = o[r], !_.relative[a = s.type]);)
                            if ((u = _.find[a]) && (i = u(s.matches[0].replace(bt, _t), vt.test(o[0].type) && l(e.parentNode) || e))) {
                                if (o.splice(r, 1), !(t = i.length && c(o))) return K.apply(n, i), n;
                                break
                            }
                    }
                    return (h || C(t, d))(i, e, !I, n, vt.test(t) && l(e.parentNode) || e), n
                }, b.sortStable = P.split("").sort(U).join("") === P, b.detectDuplicates = !!A, N(), b.sortDetached = r(function(t) {
                    return 1 & t.compareDocumentPosition(D.createElement("div"))
                }), r(function(t) {
                    return t.innerHTML = "<a href='#'></a>", "#" === t.firstChild.getAttribute("href")
                }) || o("type|href|height|width", function(t, e, n) {
                    return n ? void 0 : t.getAttribute(e, "type" === e.toLowerCase() ? 1 : 2)
                }), b.attributes && r(function(t) {
                    return t.innerHTML = "<input/>", t.firstChild.setAttribute("value", ""), "" === t.firstChild.getAttribute("value")
                }) || o("value", function(t, e, n) {
                    return n || "input" !== t.nodeName.toLowerCase() ? void 0 : t.defaultValue
                }), r(function(t) {
                    return null == t.getAttribute("disabled")
                }) || o(J, function(t, e, n) {
                    var i;
                    return n ? void 0 : !0 === t[e] ? e.toLowerCase() : (i = t.getAttributeNode(e)) && i.specified ? i.value : null
                }), e
        }(t);
        rt.find = st, rt.expr = st.selectors, rt.expr[":"] = rt.expr.pseudos, rt.unique = st.uniqueSort, rt.text = st.getText, rt.isXMLDoc = st.isXML, rt.contains = st.contains;
        var at = rt.expr.match.needsContext,
            lt = /^<(\w+)\s*\/?>(?:<\/\1>|)$/,
            ut = /^.[^:#\[\.,]*$/;
        rt.filter = function(t, e, n) {
            var i = e[0];
            return n && (t = ":not(" + t + ")"), 1 === e.length && 1 === i.nodeType ? rt.find.matchesSelector(i, t) ? [i] : [] : rt.find.matches(t, rt.grep(e, function(t) {
                return 1 === t.nodeType
            }))
        }, rt.fn.extend({
            find: function(t) {
                var e, n = [],
                    i = this,
                    r = i.length;
                if ("string" != typeof t) return this.pushStack(rt(t).filter(function() {
                    for (e = 0; r > e; e++)
                        if (rt.contains(i[e], this)) return !0
                }));
                for (e = 0; r > e; e++) rt.find(t, i[e], n);
                return n = this.pushStack(r > 1 ? rt.unique(n) : n), n.selector = this.selector ? this.selector + " " + t : t, n
            },
            filter: function(t) {
                return this.pushStack(i(this, t || [], !1))
            },
            not: function(t) {
                return this.pushStack(i(this, t || [], !0))
            },
            is: function(t) {
                return !!i(this, "string" == typeof t && at.test(t) ? rt(t) : t || [], !1).length
            }
        });
        var ct, ht = t.document,
            dt = /^(?:\s*(<[\w\W]+>)[^>]*|#([\w-]*))$/;
        (rt.fn.init = function(t, e) {
            var n, i;
            if (!t) return this;
            if ("string" == typeof t) {
                if (!(n = "<" === t.charAt(0) && ">" === t.charAt(t.length - 1) && t.length >= 3 ? [null, t, null] : dt.exec(t)) || !n[1] && e) return !e || e.jquery ? (e || ct).find(t) : this.constructor(e).find(t);
                if (n[1]) {
                    if (e = e instanceof rt ? e[0] : e, rt.merge(this, rt.parseHTML(n[1], e && e.nodeType ? e.ownerDocument || e : ht, !0)), lt.test(n[1]) && rt.isPlainObject(e))
                        for (n in e) rt.isFunction(this[n]) ? this[n](e[n]) : this.attr(n, e[n]);
                    return this
                }
                if ((i = ht.getElementById(n[2])) && i.parentNode) {
                    if (i.id !== n[2]) return ct.find(t);
                    this.length = 1, this[0] = i
                }
                return this.context = ht, this.selector = t, this
            }
            return t.nodeType ? (this.context = this[0] = t, this.length = 1, this) : rt.isFunction(t) ? void 0 !== ct.ready ? ct.ready(t) : t(rt) : (void 0 !== t.selector && (this.selector = t.selector, this.context = t.context), rt.makeArray(t, this))
        }).prototype = rt.fn, ct = rt(ht);
        var ft = /^(?:parents|prev(?:Until|All))/,
            pt = {
                children: !0,
                contents: !0,
                next: !0,
                prev: !0
            };
        rt.extend({
            dir: function(t, e, n) {
                for (var i = [], r = t[e]; r && 9 !== r.nodeType && (void 0 === n || 1 !== r.nodeType || !rt(r).is(n));) 1 === r.nodeType && i.push(r), r = r[e];
                return i
            },
            sibling: function(t, e) {
                for (var n = []; t; t = t.nextSibling) 1 === t.nodeType && t !== e && n.push(t);
                return n
            }
        }), rt.fn.extend({
            has: function(t) {
                var e, n = rt(t, this),
                    i = n.length;
                return this.filter(function() {
                    for (e = 0; i > e; e++)
                        if (rt.contains(this, n[e])) return !0
                })
            },
            closest: function(t, e) {
                for (var n, i = 0, r = this.length, o = [], s = at.test(t) || "string" != typeof t ? rt(t, e || this.context) : 0; r > i; i++)
                    for (n = this[i]; n && n !== e; n = n.parentNode)
                        if (n.nodeType < 11 && (s ? s.index(n) > -1 : 1 === n.nodeType && rt.find.matchesSelector(n, t))) {
                            o.push(n);
                            break
                        } return this.pushStack(o.length > 1 ? rt.unique(o) : o)
            },
            index: function(t) {
                return t ? "string" == typeof t ? rt.inArray(this[0], rt(t)) : rt.inArray(t.jquery ? t[0] : t, this) : this[0] && this[0].parentNode ? this.first().prevAll().length : -1
            },
            add: function(t, e) {
                return this.pushStack(rt.unique(rt.merge(this.get(), rt(t, e))))
            },
            addBack: function(t) {
                return this.add(null == t ? this.prevObject : this.prevObject.filter(t))
            }
        }), rt.each({
            parent: function(t) {
                var e = t.parentNode;
                return e && 11 !== e.nodeType ? e : null
            },
            parents: function(t) {
                return rt.dir(t, "parentNode")
            },
            parentsUntil: function(t, e, n) {
                return rt.dir(t, "parentNode", n)
            },
            next: function(t) {
                return r(t, "nextSibling")
            },
            prev: function(t) {
                return r(t, "previousSibling")
            },
            nextAll: function(t) {
                return rt.dir(t, "nextSibling")
            },
            prevAll: function(t) {
                return rt.dir(t, "previousSibling")
            },
            nextUntil: function(t, e, n) {
                return rt.dir(t, "nextSibling", n)
            },
            prevUntil: function(t, e, n) {
                return rt.dir(t, "previousSibling", n)
            },
            siblings: function(t) {
                return rt.sibling((t.parentNode || {}).firstChild, t)
            },
            children: function(t) {
                return rt.sibling(t.firstChild)
            },
            contents: function(t) {
                return rt.nodeName(t, "iframe") ? t.contentDocument || t.contentWindow.document : rt.merge([], t.childNodes)
            }
        }, function(t, e) {
            rt.fn[t] = function(n, i) {
                var r = rt.map(this, e, n);
                return "Until" !== t.slice(-5) && (i = n), i && "string" == typeof i && (r = rt.filter(i, r)), this.length > 1 && (pt[t] || (r = rt.unique(r)), ft.test(t) && (r = r.reverse())), this.pushStack(r)
            }
        });
        var mt = /\S+/g,
            gt = {};
        rt.Callbacks = function(t) {
            t = "string" == typeof t ? gt[t] || o(t) : rt.extend({}, t);
            var e, n, i, r, s, a, l = [],
                u = !t.once && [],
                c = function(o) {
                    for (n = t.memory && o, i = !0, s = a || 0, a = 0, r = l.length, e = !0; l && r > s; s++)
                        if (!1 === l[s].apply(o[0], o[1]) && t.stopOnFalse) {
                            n = !1;
                            break
                        } e = !1, l && (u ? u.length && c(u.shift()) : n ? l = [] : h.disable())
                },
                h = {
                    add: function() {
                        if (l) {
                            var i = l.length;
                            ! function e(n) {
                                rt.each(n, function(n, i) {
                                    var r = rt.type(i);
                                    "function" === r ? t.unique && h.has(i) || l.push(i) : i && i.length && "string" !== r && e(i)
                                })
                            }(arguments), e ? r = l.length : n && (a = i, c(n))
                        }
                        return this
                    },
                    remove: function() {
                        return l && rt.each(arguments, function(t, n) {
                            for (var i;
                                (i = rt.inArray(n, l, i)) > -1;) l.splice(i, 1), e && (r >= i && r--, s >= i && s--)
                        }), this
                    },
                    has: function(t) {
                        return t ? rt.inArray(t, l) > -1 : !(!l || !l.length)
                    },
                    empty: function() {
                        return l = [], r = 0, this
                    },
                    disable: function() {
                        return l = u = n = void 0, this
                    },
                    disabled: function() {
                        return !l
                    },
                    lock: function() {
                        return u = void 0, n || h.disable(), this
                    },
                    locked: function() {
                        return !u
                    },
                    fireWith: function(t, n) {
                        return !l || i && !u || (n = n || [], n = [t, n.slice ? n.slice() : n], e ? u.push(n) : c(n)), this
                    },
                    fire: function() {
                        return h.fireWith(this, arguments), this
                    },
                    fired: function() {
                        return !!i
                    }
                };
            return h
        }, rt.extend({
            Deferred: function(t) {
                var e = [
                        ["resolve", "done", rt.Callbacks("once memory"), "resolved"],
                        ["reject", "fail", rt.Callbacks("once memory"), "rejected"],
                        ["notify", "progress", rt.Callbacks("memory")]
                    ],
                    n = "pending",
                    i = {
                        state: function() {
                            return n
                        },
                        always: function() {
                            return r.done(arguments).fail(arguments), this
                        },
                        then: function() {
                            var t = arguments;
                            return rt.Deferred(function(n) {
                                rt.each(e, function(e, o) {
                                    var s = rt.isFunction(t[e]) && t[e];
                                    r[o[1]](function() {
                                        var t = s && s.apply(this, arguments);
                                        t && rt.isFunction(t.promise) ? t.promise().done(n.resolve).fail(n.reject).progress(n.notify) : n[o[0] + "With"](this === i ? n.promise() : this, s ? [t] : arguments)
                                    })
                                }), t = null
                            }).promise()
                        },
                        promise: function(t) {
                            return null != t ? rt.extend(t, i) : i
                        }
                    },
                    r = {};
                return i.pipe = i.then, rt.each(e, function(t, o) {
                    var s = o[2],
                        a = o[3];
                    i[o[1]] = s.add, a && s.add(function() {
                        n = a
                    }, e[1 ^ t][2].disable, e[2][2].lock), r[o[0]] = function() {
                        return r[o[0] + "With"](this === r ? i : this, arguments), this
                    }, r[o[0] + "With"] = s.fireWith
                }), i.promise(r), t && t.call(r, r), r
            },
            when: function(t) {
                var e, n, i, r = 0,
                    o = G.call(arguments),
                    s = o.length,
                    a = 1 !== s || t && rt.isFunction(t.promise) ? s : 0,
                    l = 1 === a ? t : rt.Deferred(),
                    u = function(t, n, i) {
                        return function(r) {
                            n[t] = this, i[t] = arguments.length > 1 ? G.call(arguments) : r, i === e ? l.notifyWith(n, i) : --a || l.resolveWith(n, i)
                        }
                    };
                if (s > 1)
                    for (e = new Array(s), n = new Array(s), i = new Array(s); s > r; r++) o[r] && rt.isFunction(o[r].promise) ? o[r].promise().done(u(r, i, o)).fail(l.reject).progress(u(r, n, e)) : --a;
                return a || l.resolveWith(i, o), l.promise()
            }
        });
        var vt;
        rt.fn.ready = function(t) {
            return rt.ready.promise().done(t), this
        }, rt.extend({
            isReady: !1,
            readyWait: 1,
            holdReady: function(t) {
                t ? rt.readyWait++ : rt.ready(!0)
            },
            ready: function(t) {
                if (!0 === t ? !--rt.readyWait : !rt.isReady) {
                    if (!ht.body) return setTimeout(rt.ready);
                    rt.isReady = !0, !0 !== t && --rt.readyWait > 0 || (vt.resolveWith(ht, [rt]), rt.fn.triggerHandler && (rt(ht).triggerHandler("ready"), rt(ht).off("ready")))
                }
            }
        }), rt.ready.promise = function(e) {
            if (!vt)
                if (vt = rt.Deferred(), "complete" === ht.readyState) setTimeout(rt.ready);
                else if (ht.addEventListener) ht.addEventListener("DOMContentLoaded", a, !1), t.addEventListener("load", a, !1);
            else {
                ht.attachEvent("onreadystatechange", a), t.attachEvent("onload", a);
                var n = !1;
                try {
                    n = null == t.frameElement && ht.documentElement
                } catch (t) {}
                n && n.doScroll && function t() {
                    if (!rt.isReady) {
                        try {
                            n.doScroll("left")
                        } catch (e) {
                            return setTimeout(t, 50)
                        }
                        s(), rt.ready()
                    }
                }()
            }
            return vt.promise(e)
        };
        var yt, bt = "undefined";
        for (yt in rt(nt)) break;
        nt.ownLast = "0" !== yt, nt.inlineBlockNeedsLayout = !1, rt(function() {
                var t, e, n, i;
                (n = ht.getElementsByTagName("body")[0]) && n.style && (e = ht.createElement("div"), i = ht.createElement("div"), i.style.cssText = "position:absolute;border:0;width:0;height:0;top:0;left:-9999px", n.appendChild(i).appendChild(e), typeof e.style.zoom !== bt && (e.style.cssText = "display:inline;margin:0;border:0;padding:1px;width:1px;zoom:1", nt.inlineBlockNeedsLayout = t = 3 === e.offsetWidth, t && (n.style.zoom = 1)), n.removeChild(i))
            }),
            function() {
                var t = ht.createElement("div");
                if (null == nt.deleteExpando) {
                    nt.deleteExpando = !0;
                    try {
                        delete t.test
                    } catch (t) {
                        nt.deleteExpando = !1
                    }
                }
                t = null
            }(), rt.acceptData = function(t) {
                var e = rt.noData[(t.nodeName + " ").toLowerCase()],
                    n = +t.nodeType || 1;
                return (1 === n || 9 === n) && (!e || !0 !== e && t.getAttribute("classid") === e)
            };
        var _t = /^(?:\{[\w\W]*\}|\[[\w\W]*\])$/,
            wt = /([A-Z])/g;
        rt.extend({
            cache: {},
            noData: {
                "applet ": !0,
                "embed ": !0,
                "object ": "clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"
            },
            hasData: function(t) {
                return !!(t = t.nodeType ? rt.cache[t[rt.expando]] : t[rt.expando]) && !u(t)
            },
            data: function(t, e, n) {
                return c(t, e, n)
            },
            removeData: function(t, e) {
                return h(t, e)
            },
            _data: function(t, e, n) {
                return c(t, e, n, !0)
            },
            _removeData: function(t, e) {
                return h(t, e, !0)
            }
        }), rt.fn.extend({
            data: function(t, e) {
                var n, i, r, o = this[0],
                    s = o && o.attributes;
                if (void 0 === t) {
                    if (this.length && (r = rt.data(o), 1 === o.nodeType && !rt._data(o, "parsedAttrs"))) {
                        for (n = s.length; n--;) s[n] && (i = s[n].name, 0 === i.indexOf("data-") && (i = rt.camelCase(i.slice(5)), l(o, i, r[i])));
                        rt._data(o, "parsedAttrs", !0)
                    }
                    return r
                }
                return "object" == typeof t ? this.each(function() {
                    rt.data(this, t)
                }) : arguments.length > 1 ? this.each(function() {
                    rt.data(this, t, e)
                }) : o ? l(o, t, rt.data(o, t)) : void 0
            },
            removeData: function(t) {
                return this.each(function() {
                    rt.removeData(this, t)
                })
            }
        }), rt.extend({
            queue: function(t, e, n) {
                var i;
                return t ? (e = (e || "fx") + "queue", i = rt._data(t, e), n && (!i || rt.isArray(n) ? i = rt._data(t, e, rt.makeArray(n)) : i.push(n)), i || []) : void 0
            },
            dequeue: function(t, e) {
                e = e || "fx";
                var n = rt.queue(t, e),
                    i = n.length,
                    r = n.shift(),
                    o = rt._queueHooks(t, e),
                    s = function() {
                        rt.dequeue(t, e)
                    };
                "inprogress" === r && (r = n.shift(), i--), r && ("fx" === e && n.unshift("inprogress"), delete o.stop, r.call(t, s, o)), !i && o && o.empty.fire()
            },
            _queueHooks: function(t, e) {
                var n = e + "queueHooks";
                return rt._data(t, n) || rt._data(t, n, {
                    empty: rt.Callbacks("once memory").add(function() {
                        rt._removeData(t, e + "queue"), rt._removeData(t, n)
                    })
                })
            }
        }), rt.fn.extend({
            queue: function(t, e) {
                var n = 2;
                return "string" != typeof t && (e = t, t = "fx", n--), arguments.length < n ? rt.queue(this[0], t) : void 0 === e ? this : this.each(function() {
                    var n = rt.queue(this, t, e);
                    rt._queueHooks(this, t), "fx" === t && "inprogress" !== n[0] && rt.dequeue(this, t)
                })
            },
            dequeue: function(t) {
                return this.each(function() {
                    rt.dequeue(this, t)
                })
            },
            clearQueue: function(t) {
                return this.queue(t || "fx", [])
            },
            promise: function(t, e) {
                var n, i = 1,
                    r = rt.Deferred(),
                    o = this,
                    s = this.length,
                    a = function() {
                        --i || r.resolveWith(o, [o])
                    };
                for ("string" != typeof t && (e = t, t = void 0), t = t || "fx"; s--;)(n = rt._data(o[s], t + "queueHooks")) && n.empty && (i++, n.empty.add(a));
                return a(), r.promise(e)
            }
        });
        var xt = /[+-]?(?:\d*\.|)\d+(?:[eE][+-]?\d+|)/.source,
            kt = ["Top", "Right", "Bottom", "Left"],
            Ct = function(t, e) {
                return t = e || t, "none" === rt.css(t, "display") || !rt.contains(t.ownerDocument, t)
            },
            Et = rt.access = function(t, e, n, i, r, o, s) {
                var a = 0,
                    l = t.length,
                    u = null == n;
                if ("object" === rt.type(n)) {
                    r = !0;
                    for (a in n) rt.access(t, e, a, n[a], !0, o, s)
                } else if (void 0 !== i && (r = !0, rt.isFunction(i) || (s = !0), u && (s ? (e.call(t, i), e = null) : (u = e, e = function(t, e, n) {
                        return u.call(rt(t), n)
                    })), e))
                    for (; l > a; a++) e(t[a], n, s ? i : i.call(t[a], a, e(t[a], n)));
                return r ? t : u ? e.call(t) : l ? e(t[0], n) : o
            },
            Tt = /^(?:checkbox|radio)$/i;
        ! function() {
            var t = ht.createElement("input"),
                e = ht.createElement("div"),
                n = ht.createDocumentFragment();
            if (e.innerHTML = "  <link/><table></table><a href='/a'>a</a><input type='checkbox'/>", nt.leadingWhitespace = 3 === e.firstChild.nodeType, nt.tbody = !e.getElementsByTagName("tbody").length, nt.htmlSerialize = !!e.getElementsByTagName("link").length, nt.html5Clone = "<:nav></:nav>" !== ht.createElement("nav").cloneNode(!0).outerHTML, t.type = "checkbox", t.checked = !0, n.appendChild(t), nt.appendChecked = t.checked, e.innerHTML = "<textarea>x</textarea>", nt.noCloneChecked = !!e.cloneNode(!0).lastChild.defaultValue, n.appendChild(e), e.innerHTML = "<input type='radio' checked='checked' name='t'/>", nt.checkClone = e.cloneNode(!0).cloneNode(!0).lastChild.checked, nt.noCloneEvent = !0, e.attachEvent && (e.attachEvent("onclick", function() {
                    nt.noCloneEvent = !1
                }), e.cloneNode(!0).click()), null == nt.deleteExpando) {
                nt.deleteExpando = !0;
                try {
                    delete e.test
                } catch (t) {
                    nt.deleteExpando = !1
                }
            }
        }(),
        function() {
            var e, n, i = ht.createElement("div");
            for (e in {
                    submit: !0,
                    change: !0,
                    focusin: !0
                }) n = "on" + e, (nt[e + "Bubbles"] = n in t) || (i.setAttribute(n, "t"), nt[e + "Bubbles"] = !1 === i.attributes[n].expando);
            i = null
        }();
        var St = /^(?:input|select|textarea)$/i,
            At = /^key/,
            Nt = /^(?:mouse|pointer|contextmenu)|click/,
            Dt = /^(?:focusinfocus|focusoutblur)$/,
            Ot = /^([^.]*)(?:\.(.+)|)$/;
        rt.event = {
            global: {},
            add: function(t, e, n, i, r) {
                var o, s, a, l, u, c, h, d, f, p, m, g = rt._data(t);
                if (g) {
                    for (n.handler && (l = n, n = l.handler, r = l.selector), n.guid || (n.guid = rt.guid++), (s = g.events) || (s = g.events = {}), (c = g.handle) || (c = g.handle = function(t) {
                            return typeof rt === bt || t && rt.event.triggered === t.type ? void 0 : rt.event.dispatch.apply(c.elem, arguments)
                        }, c.elem = t), e = (e || "").match(mt) || [""], a = e.length; a--;) o = Ot.exec(e[a]) || [], f = m = o[1], p = (o[2] || "").split(".").sort(), f && (u = rt.event.special[f] || {}, f = (r ? u.delegateType : u.bindType) || f, u = rt.event.special[f] || {}, h = rt.extend({
                        type: f,
                        origType: m,
                        data: i,
                        handler: n,
                        guid: n.guid,
                        selector: r,
                        needsContext: r && rt.expr.match.needsContext.test(r),
                        namespace: p.join(".")
                    }, l), (d = s[f]) || (d = s[f] = [], d.delegateCount = 0, u.setup && !1 !== u.setup.call(t, i, p, c) || (t.addEventListener ? t.addEventListener(f, c, !1) : t.attachEvent && t.attachEvent("on" + f, c))), u.add && (u.add.call(t, h), h.handler.guid || (h.handler.guid = n.guid)), r ? d.splice(d.delegateCount++, 0, h) : d.push(h), rt.event.global[f] = !0);
                    t = null
                }
            },
            remove: function(t, e, n, i, r) {
                var o, s, a, l, u, c, h, d, f, p, m, g = rt.hasData(t) && rt._data(t);
                if (g && (c = g.events)) {
                    for (e = (e || "").match(mt) || [""], u = e.length; u--;)
                        if (a = Ot.exec(e[u]) || [], f = m = a[1], p = (a[2] || "").split(".").sort(), f) {
                            for (h = rt.event.special[f] || {}, f = (i ? h.delegateType : h.bindType) || f, d = c[f] || [], a = a[2] && new RegExp("(^|\\.)" + p.join("\\.(?:.*\\.|)") + "(\\.|$)"), l = o = d.length; o--;) s = d[o], !r && m !== s.origType || n && n.guid !== s.guid || a && !a.test(s.namespace) || i && i !== s.selector && ("**" !== i || !s.selector) || (d.splice(o, 1), s.selector && d.delegateCount--, h.remove && h.remove.call(t, s));
                            l && !d.length && (h.teardown && !1 !== h.teardown.call(t, p, g.handle) || rt.removeEvent(t, f, g.handle), delete c[f])
                        } else
                            for (f in c) rt.event.remove(t, f + e[u], n, i, !0);
                    rt.isEmptyObject(c) && (delete g.handle, rt._removeData(t, "events"))
                }
            },
            trigger: function(e, n, i, r) {
                var o, s, a, l, u, c, h, d = [i || ht],
                    f = et.call(e, "type") ? e.type : e,
                    p = et.call(e, "namespace") ? e.namespace.split(".") : [];
                if (a = c = i = i || ht, 3 !== i.nodeType && 8 !== i.nodeType && !Dt.test(f + rt.event.triggered) && (f.indexOf(".") >= 0 && (p = f.split("."), f = p.shift(), p.sort()), s = f.indexOf(":") < 0 && "on" + f, e = e[rt.expando] ? e : new rt.Event(f, "object" == typeof e && e), e.isTrigger = r ? 2 : 3, e.namespace = p.join("."), e.namespace_re = e.namespace ? new RegExp("(^|\\.)" + p.join("\\.(?:.*\\.|)") + "(\\.|$)") : null, e.result = void 0, e.target || (e.target = i), n = null == n ? [e] : rt.makeArray(n, [e]), u = rt.event.special[f] || {}, r || !u.trigger || !1 !== u.trigger.apply(i, n))) {
                    if (!r && !u.noBubble && !rt.isWindow(i)) {
                        for (l = u.delegateType || f, Dt.test(l + f) || (a = a.parentNode); a; a = a.parentNode) d.push(a), c = a;
                        c === (i.ownerDocument || ht) && d.push(c.defaultView || c.parentWindow || t)
                    }
                    for (h = 0;
                        (a = d[h++]) && !e.isPropagationStopped();) e.type = h > 1 ? l : u.bindType || f, o = (rt._data(a, "events") || {})[e.type] && rt._data(a, "handle"), o && o.apply(a, n), (o = s && a[s]) && o.apply && rt.acceptData(a) && (e.result = o.apply(a, n), !1 === e.result && e.preventDefault());
                    if (e.type = f, !r && !e.isDefaultPrevented() && (!u._default || !1 === u._default.apply(d.pop(), n)) && rt.acceptData(i) && s && i[f] && !rt.isWindow(i)) {
                        c = i[s], c && (i[s] = null), rt.event.triggered = f;
                        try {
                            i[f]()
                        } catch (t) {}
                        rt.event.triggered = void 0, c && (i[s] = c)
                    }
                    return e.result
                }
            },
            dispatch: function(t) {
                t = rt.event.fix(t);
                var e, n, i, r, o, s = [],
                    a = G.call(arguments),
                    l = (rt._data(this, "events") || {})[t.type] || [],
                    u = rt.event.special[t.type] || {};
                if (a[0] = t, t.delegateTarget = this, !u.preDispatch || !1 !== u.preDispatch.call(this, t)) {
                    for (s = rt.event.handlers.call(this, t, l), e = 0;
                        (r = s[e++]) && !t.isPropagationStopped();)
                        for (t.currentTarget = r.elem, o = 0;
                            (i = r.handlers[o++]) && !t.isImmediatePropagationStopped();)(!t.namespace_re || t.namespace_re.test(i.namespace)) && (t.handleObj = i, t.data = i.data, void 0 !== (n = ((rt.event.special[i.origType] || {}).handle || i.handler).apply(r.elem, a)) && !1 === (t.result = n) && (t.preventDefault(), t.stopPropagation()));
                    return u.postDispatch && u.postDispatch.call(this, t), t.result
                }
            },
            handlers: function(t, e) {
                var n, i, r, o, s = [],
                    a = e.delegateCount,
                    l = t.target;
                if (a && l.nodeType && (!t.button || "click" !== t.type))
                    for (; l != this; l = l.parentNode || this)
                        if (1 === l.nodeType && (!0 !== l.disabled || "click" !== t.type)) {
                            for (r = [], o = 0; a > o; o++) i = e[o], n = i.selector + " ", void 0 === r[n] && (r[n] = i.needsContext ? rt(n, this).index(l) >= 0 : rt.find(n, this, null, [l]).length), r[n] && r.push(i);
                            r.length && s.push({
                                elem: l,
                                handlers: r
                            })
                        } return a < e.length && s.push({
                    elem: this,
                    handlers: e.slice(a)
                }), s
            },
            fix: function(t) {
                if (t[rt.expando]) return t;
                var e, n, i, r = t.type,
                    o = t,
                    s = this.fixHooks[r];
                for (s || (this.fixHooks[r] = s = Nt.test(r) ? this.mouseHooks : At.test(r) ? this.keyHooks : {}), i = s.props ? this.props.concat(s.props) : this.props, t = new rt.Event(o), e = i.length; e--;) n = i[e], t[n] = o[n];
                return t.target || (t.target = o.srcElement || ht), 3 === t.target.nodeType && (t.target = t.target.parentNode), t.metaKey = !!t.metaKey, s.filter ? s.filter(t, o) : t
            },
            props: "altKey bubbles cancelable ctrlKey currentTarget eventPhase metaKey relatedTarget shiftKey target timeStamp view which".split(" "),
            fixHooks: {},
            keyHooks: {
                props: "char charCode key keyCode".split(" "),
                filter: function(t, e) {
                    return null == t.which && (t.which = null != e.charCode ? e.charCode : e.keyCode), t
                }
            },
            mouseHooks: {
                props: "button buttons clientX clientY fromElement offsetX offsetY pageX pageY screenX screenY toElement".split(" "),
                filter: function(t, e) {
                    var n, i, r, o = e.button,
                        s = e.fromElement;
                    return null == t.pageX && null != e.clientX && (i = t.target.ownerDocument || ht, r = i.documentElement, n = i.body, t.pageX = e.clientX + (r && r.scrollLeft || n && n.scrollLeft || 0) - (r && r.clientLeft || n && n.clientLeft || 0), t.pageY = e.clientY + (r && r.scrollTop || n && n.scrollTop || 0) - (r && r.clientTop || n && n.clientTop || 0)), !t.relatedTarget && s && (t.relatedTarget = s === t.target ? e.toElement : s), t.which || void 0 === o || (t.which = 1 & o ? 1 : 2 & o ? 3 : 4 & o ? 2 : 0), t
                }
            },
            special: {
                load: {
                    noBubble: !0
                },
                focus: {
                    trigger: function() {
                        if (this !== p() && this.focus) try {
                            return this.focus(), !1
                        } catch (t) {}
                    },
                    delegateType: "focusin"
                },
                blur: {
                    trigger: function() {
                        return this === p() && this.blur ? (this.blur(), !1) : void 0
                    },
                    delegateType: "focusout"
                },
                click: {
                    trigger: function() {
                        return rt.nodeName(this, "input") && "checkbox" === this.type && this.click ? (this.click(), !1) : void 0
                    },
                    _default: function(t) {
                        return rt.nodeName(t.target, "a")
                    }
                },
                beforeunload: {
                    postDispatch: function(t) {
                        void 0 !== t.result && t.originalEvent && (t.originalEvent.returnValue = t.result)
                    }
                }
            },
            simulate: function(t, e, n, i) {
                var r = rt.extend(new rt.Event, n, {
                    type: t,
                    isSimulated: !0,
                    originalEvent: {}
                });
                i ? rt.event.trigger(r, null, e) : rt.event.dispatch.call(e, r), r.isDefaultPrevented() && n.preventDefault()
            }
        }, rt.removeEvent = ht.removeEventListener ? function(t, e, n) {
            t.removeEventListener && t.removeEventListener(e, n, !1)
        } : function(t, e, n) {
            var i = "on" + e;
            t.detachEvent && (typeof t[i] === bt && (t[i] = null), t.detachEvent(i, n))
        }, rt.Event = function(t, e) {
            return this instanceof rt.Event ? (t && t.type ? (this.originalEvent = t, this.type = t.type, this.isDefaultPrevented = t.defaultPrevented || void 0 === t.defaultPrevented && !1 === t.returnValue ? d : f) : this.type = t, e && rt.extend(this, e), this.timeStamp = t && t.timeStamp || rt.now(), void(this[rt.expando] = !0)) : new rt.Event(t, e)
        }, rt.Event.prototype = {
            isDefaultPrevented: f,
            isPropagationStopped: f,
            isImmediatePropagationStopped: f,
            preventDefault: function() {
                var t = this.originalEvent;
                this.isDefaultPrevented = d, t && (t.preventDefault ? t.preventDefault() : t.returnValue = !1)
            },
            stopPropagation: function() {
                var t = this.originalEvent;
                this.isPropagationStopped = d, t && (t.stopPropagation && t.stopPropagation(), t.cancelBubble = !0)
            },
            stopImmediatePropagation: function() {
                var t = this.originalEvent;
                this.isImmediatePropagationStopped = d, t && t.stopImmediatePropagation && t.stopImmediatePropagation(), this.stopPropagation()
            }
        }, rt.each({
            mouseenter: "mouseover",
            mouseleave: "mouseout",
            pointerenter: "pointerover",
            pointerleave: "pointerout"
        }, function(t, e) {
            rt.event.special[t] = {
                delegateType: e,
                bindType: e,
                handle: function(t) {
                    var n, i = this,
                        r = t.relatedTarget,
                        o = t.handleObj;
                    return (!r || r !== i && !rt.contains(i, r)) && (t.type = o.origType, n = o.handler.apply(this, arguments), t.type = e), n
                }
            }
        }), nt.submitBubbles || (rt.event.special.submit = {
            setup: function() {
                return !rt.nodeName(this, "form") && void rt.event.add(this, "click._submit keypress._submit", function(t) {
                    var e = t.target,
                        n = rt.nodeName(e, "input") || rt.nodeName(e, "button") ? e.form : void 0;
                    n && !rt._data(n, "submitBubbles") && (rt.event.add(n, "submit._submit", function(t) {
                        t._submit_bubble = !0
                    }), rt._data(n, "submitBubbles", !0))
                })
            },
            postDispatch: function(t) {
                t._submit_bubble && (delete t._submit_bubble, this.parentNode && !t.isTrigger && rt.event.simulate("submit", this.parentNode, t, !0))
            },
            teardown: function() {
                return !rt.nodeName(this, "form") && void rt.event.remove(this, "._submit")
            }
        }), nt.changeBubbles || (rt.event.special.change = {
            setup: function() {
                return St.test(this.nodeName) ? (("checkbox" === this.type || "radio" === this.type) && (rt.event.add(this, "propertychange._change", function(t) {
                    "checked" === t.originalEvent.propertyName && (this._just_changed = !0)
                }), rt.event.add(this, "click._change", function(t) {
                    this._just_changed && !t.isTrigger && (this._just_changed = !1), rt.event.simulate("change", this, t, !0)
                })), !1) : void rt.event.add(this, "beforeactivate._change", function(t) {
                    var e = t.target;
                    St.test(e.nodeName) && !rt._data(e, "changeBubbles") && (rt.event.add(e, "change._change", function(t) {
                        !this.parentNode || t.isSimulated || t.isTrigger || rt.event.simulate("change", this.parentNode, t, !0)
                    }), rt._data(e, "changeBubbles", !0))
                })
            },
            handle: function(t) {
                var e = t.target;
                return this !== e || t.isSimulated || t.isTrigger || "radio" !== e.type && "checkbox" !== e.type ? t.handleObj.handler.apply(this, arguments) : void 0
            },
            teardown: function() {
                return rt.event.remove(this, "._change"), !St.test(this.nodeName)
            }
        }), nt.focusinBubbles || rt.each({
            focus: "focusin",
            blur: "focusout"
        }, function(t, e) {
            var n = function(t) {
                rt.event.simulate(e, t.target, rt.event.fix(t), !0)
            };
            rt.event.special[e] = {
                setup: function() {
                    var i = this.ownerDocument || this,
                        r = rt._data(i, e);
                    r || i.addEventListener(t, n, !0), rt._data(i, e, (r || 0) + 1)
                },
                teardown: function() {
                    var i = this.ownerDocument || this,
                        r = rt._data(i, e) - 1;
                    r ? rt._data(i, e, r) : (i.removeEventListener(t, n, !0), rt._removeData(i, e))
                }
            }
        }), rt.fn.extend({
            on: function(t, e, n, i, r) {
                var o, s;
                if ("object" == typeof t) {
                    "string" != typeof e && (n = n || e, e = void 0);
                    for (o in t) this.on(o, e, n, t[o], r);
                    return this
                }
                if (null == n && null == i ? (i = e, n = e = void 0) : null == i && ("string" == typeof e ? (i = n, n = void 0) : (i = n, n = e, e = void 0)), !1 === i) i = f;
                else if (!i) return this;
                return 1 === r && (s = i, i = function(t) {
                    return rt().off(t), s.apply(this, arguments)
                }, i.guid = s.guid || (s.guid = rt.guid++)), this.each(function() {
                    rt.event.add(this, t, i, n, e)
                })
            },
            one: function(t, e, n, i) {
                return this.on(t, e, n, i, 1)
            },
            off: function(t, e, n) {
                var i, r;
                if (t && t.preventDefault && t.handleObj) return i = t.handleObj, rt(t.delegateTarget).off(i.namespace ? i.origType + "." + i.namespace : i.origType, i.selector, i.handler), this;
                if ("object" == typeof t) {
                    for (r in t) this.off(r, e, t[r]);
                    return this
                }
                return (!1 === e || "function" == typeof e) && (n = e, e = void 0), !1 === n && (n = f), this.each(function() {
                    rt.event.remove(this, t, n, e)
                })
            },
            trigger: function(t, e) {
                return this.each(function() {
                    rt.event.trigger(t, e, this)
                })
            },
            triggerHandler: function(t, e) {
                var n = this[0];
                return n ? rt.event.trigger(t, e, n, !0) : void 0
            }
        });
        var It = "abbr|article|aside|audio|bdi|canvas|data|datalist|details|figcaption|figure|footer|header|hgroup|mark|meter|nav|output|progress|section|summary|time|video",
            zt = new RegExp("<(?:" + It + ")[\\s/>]", "i"),
            Lt = /^\s+/,
            $t = /<(?!area|br|col|embed|hr|img|input|link|meta|param)(([\w:]+)[^>]*)\/>/gi,
            Rt = /<([\w:]+)/,
            Pt = /<tbody/i,
            Mt = /<|&#?\w+;/,
            jt = /<(?:script|style|link)/i,
            Ft = /checked\s*(?:[^=]|=\s*.checked.)/i,
            Bt = /^$|\/(?:java|ecma)script/i,
            Ht = /^true\/(.*)/,
            Wt = {
                option: [1, "<select multiple='multiple'>", "</select>"],
                legend: [1, "<fieldset>", "</fieldset>"],
                area: [1, "<map>", "</map>"],
                param: [1, "<object>", "</object>"],
                thead: [1, "<table>", "</table>"],
                tr: [2, "<table><tbody>", "</tbody></table>"],
                col: [2, "<table><tbody></tbody><colgroup>", "</colgroup></table>"],
                td: [3, "<table><tbody><tr>", "</tr></tbody></table>"],
                _default: nt.htmlSerialize ? [0, "", ""] : [1, "X<div>", "</div>"]
            },
            Ut = m(ht),
            qt = Ut.appendChild(ht.createElement("div"));
        Wt.optgroup = Wt.option, Wt.tbody = Wt.tfoot = Wt.colgroup = Wt.caption = Wt.thead, Wt.th = Wt.td, rt.extend({
            clone: function(t, e, n) {
                var i, r, o, s, a, l = rt.contains(t.ownerDocument, t);
                if (nt.html5Clone || rt.isXMLDoc(t) || !zt.test("<" + t.nodeName + ">") ? o = t.cloneNode(!0) : (qt.innerHTML = t.outerHTML, qt.removeChild(o = qt.firstChild)), !(nt.noCloneEvent && nt.noCloneChecked || 1 !== t.nodeType && 11 !== t.nodeType || rt.isXMLDoc(t)))
                    for (i = g(o), a = g(t), s = 0; null != (r = a[s]); ++s) i[s] && k(r, i[s]);
                if (e)
                    if (n)
                        for (a = a || g(t), i = i || g(o), s = 0; null != (r = a[s]); s++) x(r, i[s]);
                    else x(t, o);
                return i = g(o, "script"), i.length > 0 && w(i, !l && g(t, "script")), i = a = r = null, o
            },
            buildFragment: function(t, e, n, i) {
                for (var r, o, s, a, l, u, c, h = t.length, d = m(e), f = [], p = 0; h > p; p++)
                    if ((o = t[p]) || 0 === o)
                        if ("object" === rt.type(o)) rt.merge(f, o.nodeType ? [o] : o);
                        else if (Mt.test(o)) {
                    for (a = a || d.appendChild(e.createElement("div")), l = (Rt.exec(o) || ["", ""])[1].toLowerCase(), c = Wt[l] || Wt._default, a.innerHTML = c[1] + o.replace($t, "<$1></$2>") + c[2], r = c[0]; r--;) a = a.lastChild;
                    if (!nt.leadingWhitespace && Lt.test(o) && f.push(e.createTextNode(Lt.exec(o)[0])), !nt.tbody)
                        for (o = "table" !== l || Pt.test(o) ? "<table>" !== c[1] || Pt.test(o) ? 0 : a : a.firstChild, r = o && o.childNodes.length; r--;) rt.nodeName(u = o.childNodes[r], "tbody") && !u.childNodes.length && o.removeChild(u);
                    for (rt.merge(f, a.childNodes), a.textContent = ""; a.firstChild;) a.removeChild(a.firstChild);
                    a = d.lastChild
                } else f.push(e.createTextNode(o));
                for (a && d.removeChild(a), nt.appendChecked || rt.grep(g(f, "input"), v), p = 0; o = f[p++];)
                    if ((!i || -1 === rt.inArray(o, i)) && (s = rt.contains(o.ownerDocument, o), a = g(d.appendChild(o), "script"), s && w(a), n))
                        for (r = 0; o = a[r++];) Bt.test(o.type || "") && n.push(o);
                return a = null, d
            },
            cleanData: function(t, e) {
                for (var n, i, r, o, s = 0, a = rt.expando, l = rt.cache, u = nt.deleteExpando, c = rt.event.special; null != (n = t[s]); s++)
                    if ((e || rt.acceptData(n)) && (r = n[a], o = r && l[r])) {
                        if (o.events)
                            for (i in o.events) c[i] ? rt.event.remove(n, i) : rt.removeEvent(n, i, o.handle);
                        l[r] && (delete l[r], u ? delete n[a] : typeof n.removeAttribute !== bt ? n.removeAttribute(a) : n[a] = null, X.push(r))
                    }
            }
        }), rt.fn.extend({
            text: function(t) {
                return Et(this, function(t) {
                    return void 0 === t ? rt.text(this) : this.empty().append((this[0] && this[0].ownerDocument || ht).createTextNode(t))
                }, null, t, arguments.length)
            },
            append: function() {
                return this.domManip(arguments, function(t) {
                    if (1 === this.nodeType || 11 === this.nodeType || 9 === this.nodeType) {
                        y(this, t).appendChild(t)
                    }
                })
            },
            prepend: function() {
                return this.domManip(arguments, function(t) {
                    if (1 === this.nodeType || 11 === this.nodeType || 9 === this.nodeType) {
                        var e = y(this, t);
                        e.insertBefore(t, e.firstChild)
                    }
                })
            },
            before: function() {
                return this.domManip(arguments, function(t) {
                    this.parentNode && this.parentNode.insertBefore(t, this)
                })
            },
            after: function() {
                return this.domManip(arguments, function(t) {
                    this.parentNode && this.parentNode.insertBefore(t, this.nextSibling)
                })
            },
            remove: function(t, e) {
                for (var n, i = t ? rt.filter(t, this) : this, r = 0; null != (n = i[r]); r++) e || 1 !== n.nodeType || rt.cleanData(g(n)), n.parentNode && (e && rt.contains(n.ownerDocument, n) && w(g(n, "script")), n.parentNode.removeChild(n));
                return this
            },
            empty: function() {
                for (var t, e = 0; null != (t = this[e]); e++) {
                    for (1 === t.nodeType && rt.cleanData(g(t, !1)); t.firstChild;) t.removeChild(t.firstChild);
                    t.options && rt.nodeName(t, "select") && (t.options.length = 0)
                }
                return this
            },
            clone: function(t, e) {
                return t = null != t && t, e = null == e ? t : e, this.map(function() {
                    return rt.clone(this, t, e)
                })
            },
            html: function(t) {
                return Et(this, function(t) {
                    var e = this[0] || {},
                        n = 0,
                        i = this.length;
                    if (void 0 === t) return 1 === e.nodeType ? e.innerHTML.replace(/ jQuery\d+="(?:null|\d+)"/g, "") : void 0;
                    if (!("string" != typeof t || jt.test(t) || !nt.htmlSerialize && zt.test(t) || !nt.leadingWhitespace && Lt.test(t) || Wt[(Rt.exec(t) || ["", ""])[1].toLowerCase()])) {
                        t = t.replace($t, "<$1></$2>");
                        try {
                            for (; i > n; n++) e = this[n] || {}, 1 === e.nodeType && (rt.cleanData(g(e, !1)), e.innerHTML = t);
                            e = 0
                        } catch (t) {}
                    }
                    e && this.empty().append(t)
                }, null, t, arguments.length)
            },
            replaceWith: function() {
                var t = arguments[0];
                return this.domManip(arguments, function(e) {
                    t = this.parentNode, rt.cleanData(g(this)), t && t.replaceChild(e, this)
                }), t && (t.length || t.nodeType) ? this : this.remove()
            },
            detach: function(t) {
                return this.remove(t, !0)
            },
            domManip: function(t, e) {
                t = K.apply([], t);
                var n, i, r, o, s, a, l = 0,
                    u = this.length,
                    c = this,
                    h = u - 1,
                    d = t[0],
                    f = rt.isFunction(d);
                if (f || u > 1 && "string" == typeof d && !nt.checkClone && Ft.test(d)) return this.each(function(n) {
                    var i = c.eq(n);
                    f && (t[0] = d.call(this, n, i.html())), i.domManip(t, e)
                });
                if (u && (a = rt.buildFragment(t, this[0].ownerDocument, !1, this), n = a.firstChild, 1 === a.childNodes.length && (a = n), n)) {
                    for (o = rt.map(g(a, "script"), b), r = o.length; u > l; l++) i = a, l !== h && (i = rt.clone(i, !0, !0), r && rt.merge(o, g(i, "script"))), e.call(this[l], i, l);
                    if (r)
                        for (s = o[o.length - 1].ownerDocument, rt.map(o, _), l = 0; r > l; l++) i = o[l], Bt.test(i.type || "") && !rt._data(i, "globalEval") && rt.contains(s, i) && (i.src ? rt._evalUrl && rt._evalUrl(i.src) : rt.globalEval((i.text || i.textContent || i.innerHTML || "").replace(/^\s*<!(?:\[CDATA\[|--)|(?:\]\]|--)>\s*$/g, "")));
                    a = n = null
                }
                return this
            }
        }), rt.each({
            appendTo: "append",
            prependTo: "prepend",
            insertBefore: "before",
            insertAfter: "after",
            replaceAll: "replaceWith"
        }, function(t, e) {
            rt.fn[t] = function(t) {
                for (var n, i = 0, r = [], o = rt(t), s = o.length - 1; s >= i; i++) n = i === s ? this : this.clone(!0), rt(o[i])[e](n), Q.apply(r, n.get());
                return this.pushStack(r)
            }
        });
        var Vt, Zt = {};
        ! function() {
            var t;
            nt.shrinkWrapBlocks = function() {
                if (null != t) return t;
                t = !1;
                var e, n, i;
                return n = ht.getElementsByTagName("body")[0], n && n.style ? (e = ht.createElement("div"), i = ht.createElement("div"), i.style.cssText = "position:absolute;border:0;width:0;height:0;top:0;left:-9999px", n.appendChild(i).appendChild(e), typeof e.style.zoom !== bt && (e.style.cssText = "-webkit-box-sizing:content-box;-moz-box-sizing:content-box;box-sizing:content-box;display:block;margin:0;border:0;padding:1px;width:1px;zoom:1", e.appendChild(ht.createElement("div")).style.width = "5px", t = 3 !== e.offsetWidth), n.removeChild(i), t) : void 0
            }
        }();
        var Xt, Gt, Kt = /^margin/,
            Qt = new RegExp("^(" + xt + ")(?!px)[a-z%]+$", "i"),
            Yt = /^(top|right|bottom|left)$/;
        t.getComputedStyle ? (Xt = function(e) {
            return e.ownerDocument.defaultView.opener ? e.ownerDocument.defaultView.getComputedStyle(e, null) : t.getComputedStyle(e, null)
        }, Gt = function(t, e, n) {
            var i, r, o, s, a = t.style;
            return n = n || Xt(t), s = n ? n.getPropertyValue(e) || n[e] : void 0, n && ("" !== s || rt.contains(t.ownerDocument, t) || (s = rt.style(t, e)), Qt.test(s) && Kt.test(e) && (i = a.width, r = a.minWidth, o = a.maxWidth, a.minWidth = a.maxWidth = a.width = s, s = n.width, a.width = i, a.minWidth = r, a.maxWidth = o)), void 0 === s ? s : s + ""
        }) : ht.documentElement.currentStyle && (Xt = function(t) {
            return t.currentStyle
        }, Gt = function(t, e, n) {
            var i, r, o, s, a = t.style;
            return n = n || Xt(t), s = n ? n[e] : void 0, null == s && a && a[e] && (s = a[e]), Qt.test(s) && !Yt.test(e) && (i = a.left, r = t.runtimeStyle, o = r && r.left, o && (r.left = t.currentStyle.left), a.left = "fontSize" === e ? "1em" : s, s = a.pixelLeft + "px", a.left = i, o && (r.left = o)), void 0 === s ? s : s + "" || "auto"
        }), ! function() {
            function e() {
                var e, n, i, r;
                (n = ht.getElementsByTagName("body")[0]) && n.style && (e = ht.createElement("div"), i = ht.createElement("div"), i.style.cssText = "position:absolute;border:0;width:0;height:0;top:0;left:-9999px", n.appendChild(i).appendChild(e), e.style.cssText = "-webkit-box-sizing:border-box;-moz-box-sizing:border-box;box-sizing:border-box;display:block;margin-top:1%;top:1%;border:1px;padding:1px;width:4px;position:absolute", o = s = !1, l = !0, t.getComputedStyle && (o = "1%" !== (t.getComputedStyle(e, null) || {}).top, s = "4px" === (t.getComputedStyle(e, null) || {
                    width: "4px"
                }).width, r = e.appendChild(ht.createElement("div")), r.style.cssText = e.style.cssText = "-webkit-box-sizing:content-box;-moz-box-sizing:content-box;box-sizing:content-box;display:block;margin:0;border:0;padding:0", r.style.marginRight = r.style.width = "0", e.style.width = "1px", l = !parseFloat((t.getComputedStyle(r, null) || {}).marginRight), e.removeChild(r)), e.innerHTML = "<table><tr><td></td><td>t</td></tr></table>", r = e.getElementsByTagName("td"), r[0].style.cssText = "margin:0;border:0;padding:0;display:none", a = 0 === r[0].offsetHeight, a && (r[0].style.display = "", r[1].style.display = "none", a = 0 === r[0].offsetHeight), n.removeChild(i))
            }
            var n, i, r, o, s, a, l;
            n = ht.createElement("div"), n.innerHTML = "  <link/><table></table><a href='/a'>a</a><input type='checkbox'/>", r = n.getElementsByTagName("a")[0], (i = r && r.style) && (i.cssText = "float:left;opacity:.5", nt.opacity = "0.5" === i.opacity, nt.cssFloat = !!i.cssFloat, n.style.backgroundClip = "content-box", n.cloneNode(!0).style.backgroundClip = "", nt.clearCloneStyle = "content-box" === n.style.backgroundClip, nt.boxSizing = "" === i.boxSizing || "" === i.MozBoxSizing || "" === i.WebkitBoxSizing, rt.extend(nt, {
                reliableHiddenOffsets: function() {
                    return null == a && e(), a
                },
                boxSizingReliable: function() {
                    return null == s && e(), s
                },
                pixelPosition: function() {
                    return null == o && e(), o
                },
                reliableMarginRight: function() {
                    return null == l && e(), l
                }
            }))
        }(), rt.swap = function(t, e, n, i) {
            var r, o, s = {};
            for (o in e) s[o] = t.style[o], t.style[o] = e[o];
            r = n.apply(t, i || []);
            for (o in e) t.style[o] = s[o];
            return r
        };
        var Jt = /alpha\([^)]*\)/i,
            te = /opacity\s*=\s*([^)]*)/,
            ee = /^(none|table(?!-c[ea]).+)/,
            ne = new RegExp("^(" + xt + ")(.*)$", "i"),
            ie = new RegExp("^([+-])=(" + xt + ")", "i"),
            re = {
                position: "absolute",
                visibility: "hidden",
                display: "block"
            },
            oe = {
                letterSpacing: "0",
                fontWeight: "400"
            },
            se = ["Webkit", "O", "Moz", "ms"];
        rt.extend({
            cssHooks: {
                opacity: {
                    get: function(t, e) {
                        if (e) {
                            var n = Gt(t, "opacity");
                            return "" === n ? "1" : n
                        }
                    }
                }
            },
            cssNumber: {
                columnCount: !0,
                fillOpacity: !0,
                flexGrow: !0,
                flexShrink: !0,
                fontWeight: !0,
                lineHeight: !0,
                opacity: !0,
                order: !0,
                orphans: !0,
                widows: !0,
                zIndex: !0,
                zoom: !0
            },
            cssProps: {
                float: nt.cssFloat ? "cssFloat" : "styleFloat"
            },
            style: function(t, e, n, i) {
                if (t && 3 !== t.nodeType && 8 !== t.nodeType && t.style) {
                    var r, o, s, a = rt.camelCase(e),
                        l = t.style;
                    if (e = rt.cssProps[a] || (rt.cssProps[a] = S(l, a)), s = rt.cssHooks[e] || rt.cssHooks[a], void 0 === n) return s && "get" in s && void 0 !== (r = s.get(t, !1, i)) ? r : l[e];
                    if (o = typeof n, "string" === o && (r = ie.exec(n)) && (n = (r[1] + 1) * r[2] + parseFloat(rt.css(t, e)), o = "number"), null != n && n === n && ("number" !== o || rt.cssNumber[a] || (n += "px"), nt.clearCloneStyle || "" !== n || 0 !== e.indexOf("background") || (l[e] = "inherit"), !(s && "set" in s && void 0 === (n = s.set(t, n, i))))) try {
                        l[e] = n
                    } catch (t) {}
                }
            },
            css: function(t, e, n, i) {
                var r, o, s, a = rt.camelCase(e);
                return e = rt.cssProps[a] || (rt.cssProps[a] = S(t.style, a)), s = rt.cssHooks[e] || rt.cssHooks[a], s && "get" in s && (o = s.get(t, !0, n)), void 0 === o && (o = Gt(t, e, i)), "normal" === o && e in oe && (o = oe[e]), "" === n || n ? (r = parseFloat(o), !0 === n || rt.isNumeric(r) ? r || 0 : o) : o
            }
        }), rt.each(["height", "width"], function(t, e) {
            rt.cssHooks[e] = {
                get: function(t, n, i) {
                    return n ? ee.test(rt.css(t, "display")) && 0 === t.offsetWidth ? rt.swap(t, re, function() {
                        return O(t, e, i)
                    }) : O(t, e, i) : void 0
                },
                set: function(t, n, i) {
                    var r = i && Xt(t);
                    return N(t, n, i ? D(t, e, i, nt.boxSizing && "border-box" === rt.css(t, "boxSizing", !1, r), r) : 0)
                }
            }
        }), nt.opacity || (rt.cssHooks.opacity = {
            get: function(t, e) {
                return te.test((e && t.currentStyle ? t.currentStyle.filter : t.style.filter) || "") ? .01 * parseFloat(RegExp.$1) + "" : e ? "1" : ""
            },
            set: function(t, e) {
                var n = t.style,
                    i = t.currentStyle,
                    r = rt.isNumeric(e) ? "alpha(opacity=" + 100 * e + ")" : "",
                    o = i && i.filter || n.filter || "";
                n.zoom = 1, (e >= 1 || "" === e) && "" === rt.trim(o.replace(Jt, "")) && n.removeAttribute && (n.removeAttribute("filter"), "" === e || i && !i.filter) || (n.filter = Jt.test(o) ? o.replace(Jt, r) : o + " " + r)
            }
        }), rt.cssHooks.marginRight = T(nt.reliableMarginRight, function(t, e) {
            return e ? rt.swap(t, {
                display: "inline-block"
            }, Gt, [t, "marginRight"]) : void 0
        }), rt.each({
            margin: "",
            padding: "",
            border: "Width"
        }, function(t, e) {
            rt.cssHooks[t + e] = {
                expand: function(n) {
                    for (var i = 0, r = {}, o = "string" == typeof n ? n.split(" ") : [n]; 4 > i; i++) r[t + kt[i] + e] = o[i] || o[i - 2] || o[0];
                    return r
                }
            }, Kt.test(t) || (rt.cssHooks[t + e].set = N)
        }), rt.fn.extend({
            css: function(t, e) {
                return Et(this, function(t, e, n) {
                    var i, r, o = {},
                        s = 0;
                    if (rt.isArray(e)) {
                        for (i = Xt(t), r = e.length; r > s; s++) o[e[s]] = rt.css(t, e[s], !1, i);
                        return o
                    }
                    return void 0 !== n ? rt.style(t, e, n) : rt.css(t, e)
                }, t, e, arguments.length > 1)
            },
            show: function() {
                return A(this, !0)
            },
            hide: function() {
                return A(this)
            },
            toggle: function(t) {
                return "boolean" == typeof t ? t ? this.show() : this.hide() : this.each(function() {
                    Ct(this) ? rt(this).show() : rt(this).hide()
                })
            }
        }), rt.Tween = I, I.prototype = {
            constructor: I,
            init: function(t, e, n, i, r, o) {
                this.elem = t, this.prop = n, this.easing = r || "swing", this.options = e, this.start = this.now = this.cur(), this.end = i, this.unit = o || (rt.cssNumber[n] ? "" : "px")
            },
            cur: function() {
                var t = I.propHooks[this.prop];
                return t && t.get ? t.get(this) : I.propHooks._default.get(this)
            },
            run: function(t) {
                var e, n = I.propHooks[this.prop];
                return this.pos = e = this.options.duration ? rt.easing[this.easing](t, this.options.duration * t, 0, 1, this.options.duration) : t, this.now = (this.end - this.start) * e + this.start, this.options.step && this.options.step.call(this.elem, this.now, this), n && n.set ? n.set(this) : I.propHooks._default.set(this), this
            }
        }, I.prototype.init.prototype = I.prototype, I.propHooks = {
            _default: {
                get: function(t) {
                    var e;
                    return null == t.elem[t.prop] || t.elem.style && null != t.elem.style[t.prop] ? (e = rt.css(t.elem, t.prop, ""), e && "auto" !== e ? e : 0) : t.elem[t.prop]
                },
                set: function(t) {
                    rt.fx.step[t.prop] ? rt.fx.step[t.prop](t) : t.elem.style && (null != t.elem.style[rt.cssProps[t.prop]] || rt.cssHooks[t.prop]) ? rt.style(t.elem, t.prop, t.now + t.unit) : t.elem[t.prop] = t.now
                }
            }
        }, I.propHooks.scrollTop = I.propHooks.scrollLeft = {
            set: function(t) {
                t.elem.nodeType && t.elem.parentNode && (t.elem[t.prop] = t.now)
            }
        }, rt.easing = {
            linear: function(t) {
                return t
            },
            swing: function(t) {
                return .5 - Math.cos(t * Math.PI) / 2
            }
        }, rt.fx = I.prototype.init, rt.fx.step = {};
        var ae, le, ue = /^(?:toggle|show|hide)$/,
            ce = new RegExp("^(?:([+-])=|)(" + xt + ")([a-z%]*)$", "i"),
            he = /queueHooks$/,
            de = [R],
            fe = {
                "*": [function(t, e) {
                    var n = this.createTween(t, e),
                        i = n.cur(),
                        r = ce.exec(e),
                        o = r && r[3] || (rt.cssNumber[t] ? "" : "px"),
                        s = (rt.cssNumber[t] || "px" !== o && +i) && ce.exec(rt.css(n.elem, t)),
                        a = 1,
                        l = 20;
                    if (s && s[3] !== o) {
                        o = o || s[3], r = r || [], s = +i || 1;
                        do {
                            a = a || ".5", s /= a, rt.style(n.elem, t, s + o)
                        } while (a !== (a = n.cur() / i) && 1 !== a && --l)
                    }
                    return r && (s = n.start = +s || +i || 0, n.unit = o, n.end = r[1] ? s + (r[1] + 1) * r[2] : +r[2]), n
                }]
            };
        rt.Animation = rt.extend(M, {
                tweener: function(t, e) {
                    rt.isFunction(t) ? (e = t, t = ["*"]) : t = t.split(" ");
                    for (var n, i = 0, r = t.length; r > i; i++) n = t[i], fe[n] = fe[n] || [], fe[n].unshift(e)
                },
                prefilter: function(t, e) {
                    e ? de.unshift(t) : de.push(t)
                }
            }), rt.speed = function(t, e, n) {
                var i = t && "object" == typeof t ? rt.extend({}, t) : {
                    complete: n || !n && e || rt.isFunction(t) && t,
                    duration: t,
                    easing: n && e || e && !rt.isFunction(e) && e
                };
                return i.duration = rt.fx.off ? 0 : "number" == typeof i.duration ? i.duration : i.duration in rt.fx.speeds ? rt.fx.speeds[i.duration] : rt.fx.speeds._default, (null == i.queue || !0 === i.queue) && (i.queue = "fx"), i.old = i.complete, i.complete = function() {
                    rt.isFunction(i.old) && i.old.call(this), i.queue && rt.dequeue(this, i.queue)
                }, i
            }, rt.fn.extend({
                fadeTo: function(t, e, n, i) {
                    return this.filter(Ct).css("opacity", 0).show().end().animate({
                        opacity: e
                    }, t, n, i)
                },
                animate: function(t, e, n, i) {
                    var r = rt.isEmptyObject(t),
                        o = rt.speed(e, n, i),
                        s = function() {
                            var e = M(this, rt.extend({}, t), o);
                            (r || rt._data(this, "finish")) && e.stop(!0)
                        };
                    return s.finish = s, r || !1 === o.queue ? this.each(s) : this.queue(o.queue, s)
                },
                stop: function(t, e, n) {
                    var i = function(t) {
                        var e = t.stop;
                        delete t.stop, e(n)
                    };
                    return "string" != typeof t && (n = e, e = t, t = void 0), e && !1 !== t && this.queue(t || "fx", []), this.each(function() {
                        var e = !0,
                            r = null != t && t + "queueHooks",
                            o = rt.timers,
                            s = rt._data(this);
                        if (r) s[r] && s[r].stop && i(s[r]);
                        else
                            for (r in s) s[r] && s[r].stop && he.test(r) && i(s[r]);
                        for (r = o.length; r--;) o[r].elem !== this || null != t && o[r].queue !== t || (o[r].anim.stop(n), e = !1, o.splice(r, 1));
                        (e || !n) && rt.dequeue(this, t)
                    })
                },
                finish: function(t) {
                    return !1 !== t && (t = t || "fx"), this.each(function() {
                        var e, n = rt._data(this),
                            i = n[t + "queue"],
                            r = n[t + "queueHooks"],
                            o = rt.timers,
                            s = i ? i.length : 0;
                        for (n.finish = !0, rt.queue(this, t, []), r && r.stop && r.stop.call(this, !0), e = o.length; e--;) o[e].elem === this && o[e].queue === t && (o[e].anim.stop(!0), o.splice(e, 1));
                        for (e = 0; s > e; e++) i[e] && i[e].finish && i[e].finish.call(this);
                        delete n.finish
                    })
                }
            }), rt.each(["toggle", "show", "hide"], function(t, e) {
                var n = rt.fn[e];
                rt.fn[e] = function(t, i, r) {
                    return null == t || "boolean" == typeof t ? n.apply(this, arguments) : this.animate(L(e, !0), t, i, r)
                }
            }), rt.each({
                slideDown: L("show"),
                slideUp: L("hide"),
                slideToggle: L("toggle"),
                fadeIn: {
                    opacity: "show"
                },
                fadeOut: {
                    opacity: "hide"
                },
                fadeToggle: {
                    opacity: "toggle"
                }
            }, function(t, e) {
                rt.fn[t] = function(t, n, i) {
                    return this.animate(e, t, n, i)
                }
            }), rt.timers = [], rt.fx.tick = function() {
                var t, e = rt.timers,
                    n = 0;
                for (ae = rt.now(); n < e.length; n++)(t = e[n])() || e[n] !== t || e.splice(n--, 1);
                e.length || rt.fx.stop(), ae = void 0
            }, rt.fx.timer = function(t) {
                rt.timers.push(t), t() ? rt.fx.start() : rt.timers.pop()
            }, rt.fx.interval = 13, rt.fx.start = function() {
                le || (le = setInterval(rt.fx.tick, rt.fx.interval))
            }, rt.fx.stop = function() {
                clearInterval(le), le = null
            }, rt.fx.speeds = {
                slow: 600,
                fast: 200,
                _default: 400
            }, rt.fn.delay = function(t, e) {
                return t = rt.fx ? rt.fx.speeds[t] || t : t, e = e || "fx", this.queue(e, function(e, n) {
                    var i = setTimeout(e, t);
                    n.stop = function() {
                        clearTimeout(i)
                    }
                })
            },
            function() {
                var t, e, n, i, r;
                e = ht.createElement("div"), e.setAttribute("className", "t"), e.innerHTML = "  <link/><table></table><a href='/a'>a</a><input type='checkbox'/>", i = e.getElementsByTagName("a")[0], n = ht.createElement("select"), r = n.appendChild(ht.createElement("option")), t = e.getElementsByTagName("input")[0], i.style.cssText = "top:1px", nt.getSetAttribute = "t" !== e.className, nt.style = /top/.test(i.getAttribute("style")), nt.hrefNormalized = "/a" === i.getAttribute("href"), nt.checkOn = !!t.value, nt.optSelected = r.selected, nt.enctype = !!ht.createElement("form").enctype, n.disabled = !0, nt.optDisabled = !r.disabled, t = ht.createElement("input"), t.setAttribute("value", ""), nt.input = "" === t.getAttribute("value"), t.value = "t", t.setAttribute("type", "radio"), nt.radioValue = "t" === t.value
            }();
        rt.fn.extend({
            val: function(t) {
                var e, n, i, r = this[0];
                return arguments.length ? (i = rt.isFunction(t), this.each(function(n) {
                    var r;
                    1 === this.nodeType && (r = i ? t.call(this, n, rt(this).val()) : t, null == r ? r = "" : "number" == typeof r ? r += "" : rt.isArray(r) && (r = rt.map(r, function(t) {
                        return null == t ? "" : t + ""
                    })), (e = rt.valHooks[this.type] || rt.valHooks[this.nodeName.toLowerCase()]) && "set" in e && void 0 !== e.set(this, r, "value") || (this.value = r))
                })) : r ? (e = rt.valHooks[r.type] || rt.valHooks[r.nodeName.toLowerCase()], e && "get" in e && void 0 !== (n = e.get(r, "value")) ? n : (n = r.value, "string" == typeof n ? n.replace(/\r/g, "") : null == n ? "" : n)) : void 0
            }
        }), rt.extend({
            valHooks: {
                option: {
                    get: function(t) {
                        var e = rt.find.attr(t, "value");
                        return null != e ? e : rt.trim(rt.text(t))
                    }
                },
                select: {
                    get: function(t) {
                        for (var e, n, i = t.options, r = t.selectedIndex, o = "select-one" === t.type || 0 > r, s = o ? null : [], a = o ? r + 1 : i.length, l = 0 > r ? a : o ? r : 0; a > l; l++)
                            if (n = i[l], !(!n.selected && l !== r || (nt.optDisabled ? n.disabled : null !== n.getAttribute("disabled")) || n.parentNode.disabled && rt.nodeName(n.parentNode, "optgroup"))) {
                                if (e = rt(n).val(), o) return e;
                                s.push(e)
                            } return s
                    },
                    set: function(t, e) {
                        for (var n, i, r = t.options, o = rt.makeArray(e), s = r.length; s--;)
                            if (i = r[s], rt.inArray(rt.valHooks.option.get(i), o) >= 0) try {
                                i.selected = n = !0
                            } catch (t) {
                                i.scrollHeight
                            } else i.selected = !1;
                        return n || (t.selectedIndex = -1), r
                    }
                }
            }
        }), rt.each(["radio", "checkbox"], function() {
            rt.valHooks[this] = {
                set: function(t, e) {
                    return rt.isArray(e) ? t.checked = rt.inArray(rt(t).val(), e) >= 0 : void 0
                }
            }, nt.checkOn || (rt.valHooks[this].get = function(t) {
                return null === t.getAttribute("value") ? "on" : t.value
            })
        });
        var pe, me, ge = rt.expr.attrHandle,
            ve = /^(?:checked|selected)$/i,
            ye = nt.getSetAttribute,
            be = nt.input;
        rt.fn.extend({
            attr: function(t, e) {
                return Et(this, rt.attr, t, e, arguments.length > 1)
            },
            removeAttr: function(t) {
                return this.each(function() {
                    rt.removeAttr(this, t)
                })
            }
        }), rt.extend({
            attr: function(t, e, n) {
                var i, r, o = t.nodeType;
                if (t && 3 !== o && 8 !== o && 2 !== o) return typeof t.getAttribute === bt ? rt.prop(t, e, n) : (1 === o && rt.isXMLDoc(t) || (e = e.toLowerCase(), i = rt.attrHooks[e] || (rt.expr.match.bool.test(e) ? me : pe)), void 0 === n ? i && "get" in i && null !== (r = i.get(t, e)) ? r : (r = rt.find.attr(t, e), null == r ? void 0 : r) : null !== n ? i && "set" in i && void 0 !== (r = i.set(t, n, e)) ? r : (t.setAttribute(e, n + ""), n) : void rt.removeAttr(t, e))
            },
            removeAttr: function(t, e) {
                var n, i, r = 0,
                    o = e && e.match(mt);
                if (o && 1 === t.nodeType)
                    for (; n = o[r++];) i = rt.propFix[n] || n, rt.expr.match.bool.test(n) ? be && ye || !ve.test(n) ? t[i] = !1 : t[rt.camelCase("default-" + n)] = t[i] = !1 : rt.attr(t, n, ""), t.removeAttribute(ye ? n : i)
            },
            attrHooks: {
                type: {
                    set: function(t, e) {
                        if (!nt.radioValue && "radio" === e && rt.nodeName(t, "input")) {
                            var n = t.value;
                            return t.setAttribute("type", e), n && (t.value = n), e
                        }
                    }
                }
            }
        }), me = {
            set: function(t, e, n) {
                return !1 === e ? rt.removeAttr(t, n) : be && ye || !ve.test(n) ? t.setAttribute(!ye && rt.propFix[n] || n, n) : t[rt.camelCase("default-" + n)] = t[n] = !0, n
            }
        }, rt.each(rt.expr.match.bool.source.match(/\w+/g), function(t, e) {
            var n = ge[e] || rt.find.attr;
            ge[e] = be && ye || !ve.test(e) ? function(t, e, i) {
                var r, o;
                return i || (o = ge[e], ge[e] = r, r = null != n(t, e, i) ? e.toLowerCase() : null, ge[e] = o), r
            } : function(t, e, n) {
                return n ? void 0 : t[rt.camelCase("default-" + e)] ? e.toLowerCase() : null
            }
        }), be && ye || (rt.attrHooks.value = {
            set: function(t, e, n) {
                return rt.nodeName(t, "input") ? void(t.defaultValue = e) : pe && pe.set(t, e, n)
            }
        }), ye || (pe = {
            set: function(t, e, n) {
                var i = t.getAttributeNode(n);
                return i || t.setAttributeNode(i = t.ownerDocument.createAttribute(n)), i.value = e += "", "value" === n || e === t.getAttribute(n) ? e : void 0
            }
        }, ge.id = ge.name = ge.coords = function(t, e, n) {
            var i;
            return n ? void 0 : (i = t.getAttributeNode(e)) && "" !== i.value ? i.value : null
        }, rt.valHooks.button = {
            get: function(t, e) {
                var n = t.getAttributeNode(e);
                return n && n.specified ? n.value : void 0
            },
            set: pe.set
        }, rt.attrHooks.contenteditable = {
            set: function(t, e, n) {
                pe.set(t, "" !== e && e, n)
            }
        }, rt.each(["width", "height"], function(t, e) {
            rt.attrHooks[e] = {
                set: function(t, n) {
                    return "" === n ? (t.setAttribute(e, "auto"), n) : void 0
                }
            }
        })), nt.style || (rt.attrHooks.style = {
            get: function(t) {
                return t.style.cssText || void 0
            },
            set: function(t, e) {
                return t.style.cssText = e + ""
            }
        });
        var _e = /^(?:input|select|textarea|button|object)$/i,
            we = /^(?:a|area)$/i;
        rt.fn.extend({
            prop: function(t, e) {
                return Et(this, rt.prop, t, e, arguments.length > 1)
            },
            removeProp: function(t) {
                return t = rt.propFix[t] || t, this.each(function() {
                    try {
                        this[t] = void 0, delete this[t]
                    } catch (t) {}
                })
            }
        }), rt.extend({
            propFix: {
                for: "htmlFor",
                class: "className"
            },
            prop: function(t, e, n) {
                var i, r, o, s = t.nodeType;
                if (t && 3 !== s && 8 !== s && 2 !== s) return o = 1 !== s || !rt.isXMLDoc(t), o && (e = rt.propFix[e] || e, r = rt.propHooks[e]), void 0 !== n ? r && "set" in r && void 0 !== (i = r.set(t, n, e)) ? i : t[e] = n : r && "get" in r && null !== (i = r.get(t, e)) ? i : t[e]
            },
            propHooks: {
                tabIndex: {
                    get: function(t) {
                        var e = rt.find.attr(t, "tabindex");
                        return e ? parseInt(e, 10) : _e.test(t.nodeName) || we.test(t.nodeName) && t.href ? 0 : -1
                    }
                }
            }
        }), nt.hrefNormalized || rt.each(["href", "src"], function(t, e) {
            rt.propHooks[e] = {
                get: function(t) {
                    return t.getAttribute(e, 4)
                }
            }
        }), nt.optSelected || (rt.propHooks.selected = {
            get: function(t) {
                var e = t.parentNode;
                return e && (e.selectedIndex, e.parentNode && e.parentNode.selectedIndex), null
            }
        }), rt.each(["tabIndex", "readOnly", "maxLength", "cellSpacing", "cellPadding", "rowSpan", "colSpan", "useMap", "frameBorder", "contentEditable"], function() {
            rt.propFix[this.toLowerCase()] = this
        }), nt.enctype || (rt.propFix.enctype = "encoding");
        var xe = /[\t\r\n\f]/g;
        rt.fn.extend({
            addClass: function(t) {
                var e, n, i, r, o, s, a = 0,
                    l = this.length,
                    u = "string" == typeof t && t;
                if (rt.isFunction(t)) return this.each(function(e) {
                    rt(this).addClass(t.call(this, e, this.className))
                });
                if (u)
                    for (e = (t || "").match(mt) || []; l > a; a++)
                        if (n = this[a], i = 1 === n.nodeType && (n.className ? (" " + n.className + " ").replace(xe, " ") : " ")) {
                            for (o = 0; r = e[o++];) i.indexOf(" " + r + " ") < 0 && (i += r + " ");
                            s = rt.trim(i), n.className !== s && (n.className = s)
                        } return this
            },
            removeClass: function(t) {
                var e, n, i, r, o, s, a = 0,
                    l = this.length,
                    u = 0 === arguments.length || "string" == typeof t && t;
                if (rt.isFunction(t)) return this.each(function(e) {
                    rt(this).removeClass(t.call(this, e, this.className))
                });
                if (u)
                    for (e = (t || "").match(mt) || []; l > a; a++)
                        if (n = this[a], i = 1 === n.nodeType && (n.className ? (" " + n.className + " ").replace(xe, " ") : "")) {
                            for (o = 0; r = e[o++];)
                                for (; i.indexOf(" " + r + " ") >= 0;) i = i.replace(" " + r + " ", " ");
                            s = t ? rt.trim(i) : "", n.className !== s && (n.className = s)
                        } return this
            },
            toggleClass: function(t, e) {
                var n = typeof t;
                return "boolean" == typeof e && "string" === n ? e ? this.addClass(t) : this.removeClass(t) : this.each(rt.isFunction(t) ? function(n) {
                    rt(this).toggleClass(t.call(this, n, this.className, e), e)
                } : function() {
                    if ("string" === n)
                        for (var e, i = 0, r = rt(this), o = t.match(mt) || []; e = o[i++];) r.hasClass(e) ? r.removeClass(e) : r.addClass(e);
                    else(n === bt || "boolean" === n) && (this.className && rt._data(this, "__className__", this.className), this.className = this.className || !1 === t ? "" : rt._data(this, "__className__") || "")
                })
            },
            hasClass: function(t) {
                for (var e = " " + t + " ", n = 0, i = this.length; i > n; n++)
                    if (1 === this[n].nodeType && (" " + this[n].className + " ").replace(xe, " ").indexOf(e) >= 0) return !0;
                return !1
            }
        }), rt.each("blur focus focusin focusout load resize scroll unload click dblclick mousedown mouseup mousemove mouseover mouseout mouseenter mouseleave change select submit keydown keypress keyup error contextmenu".split(" "), function(t, e) {
            rt.fn[e] = function(t, n) {
                return arguments.length > 0 ? this.on(e, null, t, n) : this.trigger(e)
            }
        }), rt.fn.extend({
            hover: function(t, e) {
                return this.mouseenter(t).mouseleave(e || t)
            },
            bind: function(t, e, n) {
                return this.on(t, null, e, n)
            },
            unbind: function(t, e) {
                return this.off(t, null, e)
            },
            delegate: function(t, e, n, i) {
                return this.on(e, t, n, i)
            },
            undelegate: function(t, e, n) {
                return 1 === arguments.length ? this.off(t, "**") : this.off(e, t || "**", n)
            }
        });
        var ke = rt.now(),
            Ce = /\?/;
        rt.parseJSON = function(e) {
            if (t.JSON && t.JSON.parse) return t.JSON.parse(e + "");
            var n, i = null,
                r = rt.trim(e + "");
            return r && !rt.trim(r.replace(/(,)|(\[|{)|(}|])|"(?:[^"\\\r\n]|\\["\\\/bfnrt]|\\u[\da-fA-F]{4})*"\s*:?|true|false|null|-?(?!0\d)\d+(?:\.\d+|)(?:[eE][+-]?\d+|)/g, function(t, e, r, o) {
                return n && e && (i = 0), 0 === i ? t : (n = r || e, i += !o - !r, "")
            })) ? Function("return " + r)() : rt.error("Invalid JSON: " + e)
        }, rt.parseXML = function(e) {
            var n, i;
            if (!e || "string" != typeof e) return null;
            try {
                t.DOMParser ? (i = new DOMParser, n = i.parseFromString(e, "text/xml")) : (n = new ActiveXObject("Microsoft.XMLDOM"), n.async = "false", n.loadXML(e))
            } catch (t) {
                n = void 0
            }
            return n && n.documentElement && !n.getElementsByTagName("parsererror").length || rt.error("Invalid XML: " + e), n
        };
        var Ee, Te, Se = /([?&])_=[^&]*/,
            Ae = /^(.*?):[ \t]*([^\r\n]*)\r?$/gm,
            Ne = /^(?:about|app|app-storage|.+-extension|file|res|widget):$/,
            De = /^(?:GET|HEAD)$/,
            Oe = /^([\w.+-]+:)(?:\/\/(?:[^\/?#]*@|)([^\/?#:]*)(?::(\d+)|)|)/,
            Ie = {},
            ze = {},
            Le = "*/".concat("*");
        try {
            Te = location.href
        } catch (t) {
            Te = ht.createElement("a"), Te.href = "", Te = Te.href
        }
        Ee = Oe.exec(Te.toLowerCase()) || [], rt.extend({
            active: 0,
            lastModified: {},
            etag: {},
            ajaxSettings: {
                url: Te,
                type: "GET",
                isLocal: Ne.test(Ee[1]),
                global: !0,
                processData: !0,
                async: !0,
                contentType: "application/x-www-form-urlencoded; charset=UTF-8",
                accepts: {
                    "*": Le,
                    text: "text/plain",
                    html: "text/html",
                    xml: "application/xml, text/xml",
                    json: "application/json, text/javascript"
                },
                contents: {
                    xml: /xml/,
                    html: /html/,
                    json: /json/
                },
                responseFields: {
                    xml: "responseXML",
                    text: "responseText",
                    json: "responseJSON"
                },
                converters: {
                    "* text": String,
                    "text html": !0,
                    "text json": rt.parseJSON,
                    "text xml": rt.parseXML
                },
                flatOptions: {
                    url: !0,
                    context: !0
                }
            },
            ajaxSetup: function(t, e) {
                return e ? B(B(t, rt.ajaxSettings), e) : B(rt.ajaxSettings, t)
            },
            ajaxPrefilter: j(Ie),
            ajaxTransport: j(ze),
            ajax: function(t, e) {
                function n(t, e, n, i) {
                    var r, c, v, y, _, x = e;
                    2 !== b && (b = 2, a && clearTimeout(a), u = void 0, s = i || "", w.readyState = t > 0 ? 4 : 0, r = t >= 200 && 300 > t || 304 === t, n && (y = H(h, w, n)), y = W(h, y, w, r), r ? (h.ifModified && (_ = w.getResponseHeader("Last-Modified"), _ && (rt.lastModified[o] = _), (_ = w.getResponseHeader("etag")) && (rt.etag[o] = _)), 204 === t || "HEAD" === h.type ? x = "nocontent" : 304 === t ? x = "notmodified" : (x = y.state, c = y.data, v = y.error, r = !v)) : (v = x, (t || !x) && (x = "error", 0 > t && (t = 0))), w.status = t, w.statusText = (e || x) + "", r ? p.resolveWith(d, [c, x, w]) : p.rejectWith(d, [w, x, v]), w.statusCode(g), g = void 0, l && f.trigger(r ? "ajaxSuccess" : "ajaxError", [w, h, r ? c : v]), m.fireWith(d, [w, x]), l && (f.trigger("ajaxComplete", [w, h]), --rt.active || rt.event.trigger("ajaxStop")))
                }
                "object" == typeof t && (e = t, t = void 0), e = e || {};
                var i, r, o, s, a, l, u, c, h = rt.ajaxSetup({}, e),
                    d = h.context || h,
                    f = h.context && (d.nodeType || d.jquery) ? rt(d) : rt.event,
                    p = rt.Deferred(),
                    m = rt.Callbacks("once memory"),
                    g = h.statusCode || {},
                    v = {},
                    y = {},
                    b = 0,
                    _ = "canceled",
                    w = {
                        readyState: 0,
                        getResponseHeader: function(t) {
                            var e;
                            if (2 === b) {
                                if (!c)
                                    for (c = {}; e = Ae.exec(s);) c[e[1].toLowerCase()] = e[2];
                                e = c[t.toLowerCase()]
                            }
                            return null == e ? null : e
                        },
                        getAllResponseHeaders: function() {
                            return 2 === b ? s : null
                        },
                        setRequestHeader: function(t, e) {
                            var n = t.toLowerCase();
                            return b || (t = y[n] = y[n] || t, v[t] = e), this
                        },
                        overrideMimeType: function(t) {
                            return b || (h.mimeType = t), this
                        },
                        statusCode: function(t) {
                            var e;
                            if (t)
                                if (2 > b)
                                    for (e in t) g[e] = [g[e], t[e]];
                                else w.always(t[w.status]);
                            return this
                        },
                        abort: function(t) {
                            var e = t || _;
                            return u && u.abort(e), n(0, e), this
                        }
                    };
                if (p.promise(w).complete = m.add, w.success = w.done, w.error = w.fail, h.url = ((t || h.url || Te) + "").replace(/#.*$/, "").replace(/^\/\//, Ee[1] + "//"), h.type = e.method || e.type || h.method || h.type, h.dataTypes = rt.trim(h.dataType || "*").toLowerCase().match(mt) || [""], null == h.crossDomain && (i = Oe.exec(h.url.toLowerCase()), h.crossDomain = !(!i || i[1] === Ee[1] && i[2] === Ee[2] && (i[3] || ("http:" === i[1] ? "80" : "443")) === (Ee[3] || ("http:" === Ee[1] ? "80" : "443")))), h.data && h.processData && "string" != typeof h.data && (h.data = rt.param(h.data, h.traditional)), F(Ie, h, e, w), 2 === b) return w;
                l = rt.event && h.global, l && 0 == rt.active++ && rt.event.trigger("ajaxStart"), h.type = h.type.toUpperCase(), h.hasContent = !De.test(h.type), o = h.url, h.hasContent || (h.data && (o = h.url += (Ce.test(o) ? "&" : "?") + h.data, delete h.data), !1 === h.cache && (h.url = Se.test(o) ? o.replace(Se, "$1_=" + ke++) : o + (Ce.test(o) ? "&" : "?") + "_=" + ke++)), h.ifModified && (rt.lastModified[o] && w.setRequestHeader("If-Modified-Since", rt.lastModified[o]), rt.etag[o] && w.setRequestHeader("If-None-Match", rt.etag[o])), (h.data && h.hasContent && !1 !== h.contentType || e.contentType) && w.setRequestHeader("Content-Type", h.contentType), w.setRequestHeader("Accept", h.dataTypes[0] && h.accepts[h.dataTypes[0]] ? h.accepts[h.dataTypes[0]] + ("*" !== h.dataTypes[0] ? ", " + Le + "; q=0.01" : "") : h.accepts["*"]);
                for (r in h.headers) w.setRequestHeader(r, h.headers[r]);
                if (h.beforeSend && (!1 === h.beforeSend.call(d, w, h) || 2 === b)) return w.abort();
                _ = "abort";
                for (r in {
                        success: 1,
                        error: 1,
                        complete: 1
                    }) w[r](h[r]);
                if (u = F(ze, h, e, w)) {
                    w.readyState = 1, l && f.trigger("ajaxSend", [w, h]), h.async && h.timeout > 0 && (a = setTimeout(function() {
                        w.abort("timeout")
                    }, h.timeout));
                    try {
                        b = 1, u.send(v, n)
                    } catch (t) {
                        if (!(2 > b)) throw t;
                        n(-1, t)
                    }
                } else n(-1, "No Transport");
                return w
            },
            getJSON: function(t, e, n) {
                return rt.get(t, e, n, "json")
            },
            getScript: function(t, e) {
                return rt.get(t, void 0, e, "script")
            }
        }), rt.each(["get", "post"], function(t, e) {
            rt[e] = function(t, n, i, r) {
                return rt.isFunction(n) && (r = r || i, i = n, n = void 0), rt.ajax({
                    url: t,
                    type: e,
                    dataType: r,
                    data: n,
                    success: i
                })
            }
        }), rt._evalUrl = function(t) {
            return rt.ajax({
                url: t,
                type: "GET",
                dataType: "script",
                async: !1,
                global: !1,
                throws: !0
            })
        }, rt.fn.extend({
            wrapAll: function(t) {
                if (rt.isFunction(t)) return this.each(function(e) {
                    rt(this).wrapAll(t.call(this, e))
                });
                if (this[0]) {
                    var e = rt(t, this[0].ownerDocument).eq(0).clone(!0);
                    this[0].parentNode && e.insertBefore(this[0]), e.map(function() {
                        for (var t = this; t.firstChild && 1 === t.firstChild.nodeType;) t = t.firstChild;
                        return t
                    }).append(this)
                }
                return this
            },
            wrapInner: function(t) {
                return this.each(rt.isFunction(t) ? function(e) {
                    rt(this).wrapInner(t.call(this, e))
                } : function() {
                    var e = rt(this),
                        n = e.contents();
                    n.length ? n.wrapAll(t) : e.append(t)
                })
            },
            wrap: function(t) {
                var e = rt.isFunction(t);
                return this.each(function(n) {
                    rt(this).wrapAll(e ? t.call(this, n) : t)
                })
            },
            unwrap: function() {
                return this.parent().each(function() {
                    rt.nodeName(this, "body") || rt(this).replaceWith(this.childNodes)
                }).end()
            }
        }), rt.expr.filters.hidden = function(t) {
            return t.offsetWidth <= 0 && t.offsetHeight <= 0 || !nt.reliableHiddenOffsets() && "none" === (t.style && t.style.display || rt.css(t, "display"))
        }, rt.expr.filters.visible = function(t) {
            return !rt.expr.filters.hidden(t)
        };
        var $e = /\[\]$/,
            Re = /^(?:submit|button|image|reset|file)$/i,
            Pe = /^(?:input|select|textarea|keygen)/i;
        rt.param = function(t, e) {
            var n, i = [],
                r = function(t, e) {
                    e = rt.isFunction(e) ? e() : null == e ? "" : e, i[i.length] = encodeURIComponent(t) + "=" + encodeURIComponent(e)
                };
            if (void 0 === e && (e = rt.ajaxSettings && rt.ajaxSettings.traditional), rt.isArray(t) || t.jquery && !rt.isPlainObject(t)) rt.each(t, function() {
                r(this.name, this.value)
            });
            else
                for (n in t) U(n, t[n], e, r);
            return i.join("&").replace(/%20/g, "+")
        }, rt.fn.extend({
            serialize: function() {
                return rt.param(this.serializeArray())
            },
            serializeArray: function() {
                return this.map(function() {
                    var t = rt.prop(this, "elements");
                    return t ? rt.makeArray(t) : this
                }).filter(function() {
                    var t = this.type;
                    return this.name && !rt(this).is(":disabled") && Pe.test(this.nodeName) && !Re.test(t) && (this.checked || !Tt.test(t))
                }).map(function(t, e) {
                    var n = rt(this).val();
                    return null == n ? null : rt.isArray(n) ? rt.map(n, function(t) {
                        return {
                            name: e.name,
                            value: t.replace(/\r?\n/g, "\r\n")
                        }
                    }) : {
                        name: e.name,
                        value: n.replace(/\r?\n/g, "\r\n")
                    }
                }).get()
            }
        }), rt.ajaxSettings.xhr = void 0 !== t.ActiveXObject ? function() {
            return !this.isLocal && /^(get|post|head|put|delete|options)$/i.test(this.type) && q() || V()
        } : q;
        var Me = 0,
            je = {},
            Fe = rt.ajaxSettings.xhr();
        t.attachEvent && t.attachEvent("onunload", function() {
            for (var t in je) je[t](void 0, !0)
        }), nt.cors = !!Fe && "withCredentials" in Fe, (Fe = nt.ajax = !!Fe) && rt.ajaxTransport(function(t) {
            if (!t.crossDomain || nt.cors) {
                var e;
                return {
                    send: function(n, i) {
                        var r, o = t.xhr(),
                            s = ++Me;
                        if (o.open(t.type, t.url, t.async, t.username, t.password), t.xhrFields)
                            for (r in t.xhrFields) o[r] = t.xhrFields[r];
                        t.mimeType && o.overrideMimeType && o.overrideMimeType(t.mimeType), t.crossDomain || n["X-Requested-With"] || (n["X-Requested-With"] = "XMLHttpRequest");
                        for (r in n) void 0 !== n[r] && o.setRequestHeader(r, n[r] + "");
                        o.send(t.hasContent && t.data || null), e = function(n, r) {
                            var a, l, u;
                            if (e && (r || 4 === o.readyState))
                                if (delete je[s], e = void 0, o.onreadystatechange = rt.noop, r) 4 !== o.readyState && o.abort();
                                else {
                                    u = {}, a = o.status, "string" == typeof o.responseText && (u.text = o.responseText);
                                    try {
                                        l = o.statusText
                                    } catch (t) {
                                        l = ""
                                    }
                                    a || !t.isLocal || t.crossDomain ? 1223 === a && (a = 204) : a = u.text ? 200 : 404
                                } u && i(a, l, u, o.getAllResponseHeaders())
                        }, t.async ? 4 === o.readyState ? setTimeout(e) : o.onreadystatechange = je[s] = e : e()
                    },
                    abort: function() {
                        e && e(void 0, !0)
                    }
                }
            }
        }), rt.ajaxSetup({
            accepts: {
                script: "text/javascript, application/javascript, application/ecmascript, application/x-ecmascript"
            },
            contents: {
                script: /(?:java|ecma)script/
            },
            converters: {
                "text script": function(t) {
                    return rt.globalEval(t), t
                }
            }
        }), rt.ajaxPrefilter("script", function(t) {
            void 0 === t.cache && (t.cache = !1), t.crossDomain && (t.type = "GET", t.global = !1)
        }), rt.ajaxTransport("script", function(t) {
            if (t.crossDomain) {
                var e, n = ht.head || rt("head")[0] || ht.documentElement;
                return {
                    send: function(i, r) {
                        e = ht.createElement("script"), e.async = !0, t.scriptCharset && (e.charset = t.scriptCharset), e.src = t.url, e.onload = e.onreadystatechange = function(t, n) {
                            (n || !e.readyState || /loaded|complete/.test(e.readyState)) && (e.onload = e.onreadystatechange = null, e.parentNode && e.parentNode.removeChild(e), e = null, n || r(200, "success"))
                        }, n.insertBefore(e, n.firstChild)
                    },
                    abort: function() {
                        e && e.onload(void 0, !0)
                    }
                }
            }
        });
        var Be = [],
            He = /(=)\?(?=&|$)|\?\?/;
        rt.ajaxSetup({
            jsonp: "callback",
            jsonpCallback: function() {
                var t = Be.pop() || rt.expando + "_" + ke++;
                return this[t] = !0, t
            }
        }), rt.ajaxPrefilter("json jsonp", function(e, n, i) {
            var r, o, s, a = !1 !== e.jsonp && (He.test(e.url) ? "url" : "string" == typeof e.data && !(e.contentType || "").indexOf("application/x-www-form-urlencoded") && He.test(e.data) && "data");
            return a || "jsonp" === e.dataTypes[0] ? (r = e.jsonpCallback = rt.isFunction(e.jsonpCallback) ? e.jsonpCallback() : e.jsonpCallback, a ? e[a] = e[a].replace(He, "$1" + r) : !1 !== e.jsonp && (e.url += (Ce.test(e.url) ? "&" : "?") + e.jsonp + "=" + r), e.converters["script json"] = function() {
                return s || rt.error(r + " was not called"), s[0]
            }, e.dataTypes[0] = "json", o = t[r], t[r] = function() {
                s = arguments
            }, i.always(function() {
                t[r] = o, e[r] && (e.jsonpCallback = n.jsonpCallback, Be.push(r)), s && rt.isFunction(o) && o(s[0]), s = o = void 0
            }), "script") : void 0
        }), rt.parseHTML = function(t, e, n) {
            if (!t || "string" != typeof t) return null;
            "boolean" == typeof e && (n = e, e = !1), e = e || ht;
            var i = lt.exec(t),
                r = !n && [];
            return i ? [e.createElement(i[1])] : (i = rt.buildFragment([t], e, r), r && r.length && rt(r).remove(), rt.merge([], i.childNodes))
        };
        var We = rt.fn.load;
        rt.fn.load = function(t, e, n) {
            if ("string" != typeof t && We) return We.apply(this, arguments);
            var i, r, o, s = this,
                a = t.indexOf(" ");
            return a >= 0 && (i = rt.trim(t.slice(a, t.length)), t = t.slice(0, a)), rt.isFunction(e) ? (n = e, e = void 0) : e && "object" == typeof e && (o = "POST"), s.length > 0 && rt.ajax({
                url: t,
                type: o,
                dataType: "html",
                data: e
            }).done(function(t) {
                r = arguments, s.html(i ? rt("<div>").append(rt.parseHTML(t)).find(i) : t)
            }).complete(n && function(t, e) {
                s.each(n, r || [t.responseText, e, t])
            }), this
        }, rt.each(["ajaxStart", "ajaxStop", "ajaxComplete", "ajaxError", "ajaxSuccess", "ajaxSend"], function(t, e) {
            rt.fn[e] = function(t) {
                return this.on(e, t)
            }
        }), rt.expr.filters.animated = function(t) {
            return rt.grep(rt.timers, function(e) {
                return t === e.elem
            }).length
        };
        var Ue = t.document.documentElement;
        rt.offset = {
            setOffset: function(t, e, n) {
                var i, r, o, s, a, l, u, c = rt.css(t, "position"),
                    h = rt(t),
                    d = {};
                "static" === c && (t.style.position = "relative"), a = h.offset(), o = rt.css(t, "top"), l = rt.css(t, "left"), u = ("absolute" === c || "fixed" === c) && rt.inArray("auto", [o, l]) > -1, u ? (i = h.position(), s = i.top, r = i.left) : (s = parseFloat(o) || 0, r = parseFloat(l) || 0), rt.isFunction(e) && (e = e.call(t, n, a)), null != e.top && (d.top = e.top - a.top + s), null != e.left && (d.left = e.left - a.left + r), "using" in e ? e.using.call(t, d) : h.css(d)
            }
        }, rt.fn.extend({
            offset: function(t) {
                if (arguments.length) return void 0 === t ? this : this.each(function(e) {
                    rt.offset.setOffset(this, t, e)
                });
                var e, n, i = {
                        top: 0,
                        left: 0
                    },
                    r = this[0],
                    o = r && r.ownerDocument;
                return o ? (e = o.documentElement, rt.contains(e, r) ? (typeof r.getBoundingClientRect !== bt && (i = r.getBoundingClientRect()), n = Z(o), {
                    top: i.top + (n.pageYOffset || e.scrollTop) - (e.clientTop || 0),
                    left: i.left + (n.pageXOffset || e.scrollLeft) - (e.clientLeft || 0)
                }) : i) : void 0
            },
            position: function() {
                if (this[0]) {
                    var t, e, n = {
                            top: 0,
                            left: 0
                        },
                        i = this[0];
                    return "fixed" === rt.css(i, "position") ? e = i.getBoundingClientRect() : (t = this.offsetParent(), e = this.offset(), rt.nodeName(t[0], "html") || (n = t.offset()), n.top += rt.css(t[0], "borderTopWidth", !0), n.left += rt.css(t[0], "borderLeftWidth", !0)), {
                        top: e.top - n.top - rt.css(i, "marginTop", !0),
                        left: e.left - n.left - rt.css(i, "marginLeft", !0)
                    }
                }
            },
            offsetParent: function() {
                return this.map(function() {
                    for (var t = this.offsetParent || Ue; t && !rt.nodeName(t, "html") && "static" === rt.css(t, "position");) t = t.offsetParent;
                    return t || Ue
                })
            }
        }), rt.each({
            scrollLeft: "pageXOffset",
            scrollTop: "pageYOffset"
        }, function(t, e) {
            var n = /Y/.test(e);
            rt.fn[t] = function(i) {
                return Et(this, function(t, i, r) {
                    var o = Z(t);
                    return void 0 === r ? o ? e in o ? o[e] : o.document.documentElement[i] : t[i] : void(o ? o.scrollTo(n ? rt(o).scrollLeft() : r, n ? r : rt(o).scrollTop()) : t[i] = r)
                }, t, i, arguments.length, null)
            }
        }), rt.each(["top", "left"], function(t, e) {
            rt.cssHooks[e] = T(nt.pixelPosition, function(t, n) {
                return n ? (n = Gt(t, e), Qt.test(n) ? rt(t).position()[e] + "px" : n) : void 0
            })
        }), rt.each({
            Height: "height",
            Width: "width"
        }, function(t, e) {
            rt.each({
                padding: "inner" + t,
                content: e,
                "": "outer" + t
            }, function(n, i) {
                rt.fn[i] = function(i, r) {
                    var o = arguments.length && (n || "boolean" != typeof i),
                        s = n || (!0 === i || !0 === r ? "margin" : "border");
                    return Et(this, function(e, n, i) {
                        var r;
                        return rt.isWindow(e) ? e.document.documentElement["client" + t] : 9 === e.nodeType ? (r = e.documentElement,
                            Math.max(e.body["scroll" + t], r["scroll" + t], e.body["offset" + t], r["offset" + t], r["client" + t])) : void 0 === i ? rt.css(e, n, s) : rt.style(e, n, i, s)
                    }, e, o ? i : void 0, o, null)
                }
            })
        }), rt.fn.size = function() {
            return this.length
        }, rt.fn.andSelf = rt.fn.addBack, "function" == typeof define && define.amd && define("jquery", [], function() {
            return rt
        });
        var qe = t.jQuery,
            Ve = t.$;
        return rt.noConflict = function(e) {
            return t.$ === rt && (t.$ = Ve), e && t.jQuery === rt && (t.jQuery = qe), rt
        }, typeof e === bt && (t.jQuery = t.$ = rt), rt
    }), "undefined" == typeof jQuery) throw new Error("Bootstrap's JavaScript requires jQuery"); + function(t) {
    "use strict";
    var e = t.fn.jquery.split(" ")[0].split(".");
    if (e[0] < 2 && e[1] < 9 || 1 == e[0] && 9 == e[1] && e[2] < 1) throw new Error("Bootstrap's JavaScript requires jQuery version 1.9.1 or higher")
}(jQuery),
function(t) {
    "use strict";

    function e() {
        var t = document.createElement("bootstrap"),
            e = {
                WebkitTransition: "webkitTransitionEnd",
                MozTransition: "transitionend",
                OTransition: "oTransitionEnd otransitionend",
                transition: "transitionend"
            };
        for (var n in e)
            if (void 0 !== t.style[n]) return {
                end: e[n]
            };
        return !1
    }
    t.fn.emulateTransitionEnd = function(e) {
        var n = !1,
            i = this;
        t(this).one("bsTransitionEnd", function() {
            n = !0
        });
        var r = function() {
            n || t(i).trigger(t.support.transition.end)
        };
        return setTimeout(r, e), this
    }, t(function() {
        t.support.transition = e(), t.support.transition && (t.event.special.bsTransitionEnd = {
            bindType: t.support.transition.end,
            delegateType: t.support.transition.end,
            handle: function(e) {
                return t(e.target).is(this) ? e.handleObj.handler.apply(this, arguments) : void 0
            }
        })
    })
}(jQuery),
function(t) {
    "use strict";

    function e(e) {
        return this.each(function() {
            var n = t(this),
                r = n.data("bs.alert");
            r || n.data("bs.alert", r = new i(this)), "string" == typeof e && r[e].call(n)
        })
    }
    var n = '[data-dismiss="alert"]',
        i = function(e) {
            t(e).on("click", n, this.close)
        };
    i.VERSION = "3.3.2", i.TRANSITION_DURATION = 150, i.prototype.close = function(e) {
        function n() {
            s.detach().trigger("closed.bs.alert").remove()
        }
        var r = t(this),
            o = r.attr("data-target");
        o || (o = r.attr("href"), o = o && o.replace(/.*(?=#[^\s]*$)/, ""));
        var s = t(o);
        e && e.preventDefault(), s.length || (s = r.closest(".alert")), s.trigger(e = t.Event("close.bs.alert")), e.isDefaultPrevented() || (s.removeClass("in"), t.support.transition && s.hasClass("fade") ? s.one("bsTransitionEnd", n).emulateTransitionEnd(i.TRANSITION_DURATION) : n())
    };
    var r = t.fn.alert;
    t.fn.alert = e, t.fn.alert.Constructor = i, t.fn.alert.noConflict = function() {
        return t.fn.alert = r, this
    }, t(document).on("click.bs.alert.data-api", n, i.prototype.close)
}(jQuery),
function(t) {
    "use strict";

    function e(e) {
        return this.each(function() {
            var i = t(this),
                r = i.data("bs.button"),
                o = "object" == typeof e && e;
            r || i.data("bs.button", r = new n(this, o)), "toggle" == e ? r.toggle() : e && r.setState(e)
        })
    }
    var n = function(e, i) {
        this.$element = t(e), this.options = t.extend({}, n.DEFAULTS, i), this.isLoading = !1
    };
    n.VERSION = "3.3.2", n.DEFAULTS = {
        loadingText: "loading..."
    }, n.prototype.setState = function(e) {
        var n = "disabled",
            i = this.$element,
            r = i.is("input") ? "val" : "html",
            o = i.data();
        e += "Text", null == o.resetText && i.data("resetText", i[r]()), setTimeout(t.proxy(function() {
            i[r](null == o[e] ? this.options[e] : o[e]), "loadingText" == e ? (this.isLoading = !0, i.addClass(n).attr(n, n)) : this.isLoading && (this.isLoading = !1, i.removeClass(n).removeAttr(n))
        }, this), 0)
    }, n.prototype.toggle = function() {
        var t = !0,
            e = this.$element.closest('[data-toggle="buttons"]');
        if (e.length) {
            var n = this.$element.find("input");
            "radio" == n.prop("type") && (n.prop("checked") && this.$element.hasClass("active") ? t = !1 : e.find(".active").removeClass("active")), t && n.prop("checked", !this.$element.hasClass("active")).trigger("change")
        } else this.$element.attr("aria-pressed", !this.$element.hasClass("active"));
        t && this.$element.toggleClass("active")
    };
    var i = t.fn.button;
    t.fn.button = e, t.fn.button.Constructor = n, t.fn.button.noConflict = function() {
        return t.fn.button = i, this
    }, t(document).on("click.bs.button.data-api", '[data-toggle^="button"]', function(n) {
        var i = t(n.target);
        i.hasClass("btn") || (i = i.closest(".btn")), e.call(i, "toggle"), n.preventDefault()
    }).on("focus.bs.button.data-api blur.bs.button.data-api", '[data-toggle^="button"]', function(e) {
        t(e.target).closest(".btn").toggleClass("focus", /^focus(in)?$/.test(e.type))
    })
}(jQuery),
function(t) {
    "use strict";

    function e(e) {
        return this.each(function() {
            var i = t(this),
                r = i.data("bs.carousel"),
                o = t.extend({}, n.DEFAULTS, i.data(), "object" == typeof e && e),
                s = "string" == typeof e ? e : o.slide;
            r || i.data("bs.carousel", r = new n(this, o)), "number" == typeof e ? r.to(e) : s ? r[s]() : o.interval && r.pause().cycle()
        })
    }
    var n = function(e, n) {
        this.$element = t(e), this.$indicators = this.$element.find(".carousel-indicators"), this.options = n, this.paused = this.sliding = this.interval = this.$active = this.$items = null, this.options.keyboard && this.$element.on("keydown.bs.carousel", t.proxy(this.keydown, this)), "hover" == this.options.pause && !("ontouchstart" in document.documentElement) && this.$element.on("mouseenter.bs.carousel", t.proxy(this.pause, this)).on("mouseleave.bs.carousel", t.proxy(this.cycle, this))
    };
    n.VERSION = "3.3.2", n.TRANSITION_DURATION = 600, n.DEFAULTS = {
        interval: 5e3,
        pause: "hover",
        wrap: !0,
        keyboard: !0
    }, n.prototype.keydown = function(t) {
        if (!/input|textarea/i.test(t.target.tagName)) {
            switch (t.which) {
                case 37:
                    this.prev();
                    break;
                case 39:
                    this.next();
                    break;
                default:
                    return
            }
            t.preventDefault()
        }
    }, n.prototype.cycle = function(e) {
        return e || (this.paused = !1), this.interval && clearInterval(this.interval), this.options.interval && !this.paused && (this.interval = setInterval(t.proxy(this.next, this), this.options.interval)), this
    }, n.prototype.getItemIndex = function(t) {
        return this.$items = t.parent().children(".item"), this.$items.index(t || this.$active)
    }, n.prototype.getItemForDirection = function(t, e) {
        var n = this.getItemIndex(e);
        if (("prev" == t && 0 === n || "next" == t && n == this.$items.length - 1) && !this.options.wrap) return e;
        var i = "prev" == t ? -1 : 1,
            r = (n + i) % this.$items.length;
        return this.$items.eq(r)
    }, n.prototype.to = function(t) {
        var e = this,
            n = this.getItemIndex(this.$active = this.$element.find(".item.active"));
        return t > this.$items.length - 1 || 0 > t ? void 0 : this.sliding ? this.$element.one("slid.bs.carousel", function() {
            e.to(t)
        }) : n == t ? this.pause().cycle() : this.slide(t > n ? "next" : "prev", this.$items.eq(t))
    }, n.prototype.pause = function(e) {
        return e || (this.paused = !0), this.$element.find(".next, .prev").length && t.support.transition && (this.$element.trigger(t.support.transition.end), this.cycle(!0)), this.interval = clearInterval(this.interval), this
    }, n.prototype.next = function() {
        return this.sliding ? void 0 : this.slide("next")
    }, n.prototype.prev = function() {
        return this.sliding ? void 0 : this.slide("prev")
    }, n.prototype.slide = function(e, i) {
        var r = this.$element.find(".item.active"),
            o = i || this.getItemForDirection(e, r),
            s = this.interval,
            a = "next" == e ? "left" : "right",
            l = this;
        if (o.hasClass("active")) return this.sliding = !1;
        var u = o[0],
            c = t.Event("slide.bs.carousel", {
                relatedTarget: u,
                direction: a
            });
        if (this.$element.trigger(c), !c.isDefaultPrevented()) {
            if (this.sliding = !0, s && this.pause(), this.$indicators.length) {
                this.$indicators.find(".active").removeClass("active");
                var h = t(this.$indicators.children()[this.getItemIndex(o)]);
                h && h.addClass("active")
            }
            var d = t.Event("slid.bs.carousel", {
                relatedTarget: u,
                direction: a
            });
            return t.support.transition && this.$element.hasClass("slide") ? (o.addClass(e), o[0].offsetWidth, r.addClass(a), o.addClass(a), r.one("bsTransitionEnd", function() {
                o.removeClass([e, a].join(" ")).addClass("active"), r.removeClass(["active", a].join(" ")), l.sliding = !1, setTimeout(function() {
                    l.$element.trigger(d)
                }, 0)
            }).emulateTransitionEnd(n.TRANSITION_DURATION)) : (r.removeClass("active"), o.addClass("active"), this.sliding = !1, this.$element.trigger(d)), s && this.cycle(), this
        }
    };
    var i = t.fn.carousel;
    t.fn.carousel = e, t.fn.carousel.Constructor = n, t.fn.carousel.noConflict = function() {
        return t.fn.carousel = i, this
    };
    var r = function(n) {
        var i, r = t(this),
            o = t(r.attr("data-target") || (i = r.attr("href")) && i.replace(/.*(?=#[^\s]+$)/, ""));
        if (o.hasClass("carousel")) {
            var s = t.extend({}, o.data(), r.data()),
                a = r.attr("data-slide-to");
            a && (s.interval = !1), e.call(o, s), a && o.data("bs.carousel").to(a), n.preventDefault()
        }
    };
    t(document).on("click.bs.carousel.data-api", "[data-slide]", r).on("click.bs.carousel.data-api", "[data-slide-to]", r), t(window).on("load", function() {
        t('[data-ride="carousel"]').each(function() {
            var n = t(this);
            e.call(n, n.data())
        })
    })
}(jQuery),
function(t) {
    "use strict";

    function e(e) {
        var n, i = e.attr("data-target") || (n = e.attr("href")) && n.replace(/.*(?=#[^\s]+$)/, "");
        return t(i)
    }

    function n(e) {
        return this.each(function() {
            var n = t(this),
                r = n.data("bs.collapse"),
                o = t.extend({}, i.DEFAULTS, n.data(), "object" == typeof e && e);
            !r && o.toggle && "show" == e && (o.toggle = !1), r || n.data("bs.collapse", r = new i(this, o)), "string" == typeof e && r[e]()
        })
    }
    var i = function(e, n) {
        this.$element = t(e), this.options = t.extend({}, i.DEFAULTS, n), this.$trigger = t(this.options.trigger).filter('[href="#' + e.id + '"], [data-target="#' + e.id + '"]'), this.transitioning = null, this.options.parent ? this.$parent = this.getParent() : this.addAriaAndCollapsedClass(this.$element, this.$trigger), this.options.toggle && this.toggle()
    };
    i.VERSION = "3.3.2", i.TRANSITION_DURATION = 350, i.DEFAULTS = {
        toggle: !0,
        trigger: '[data-toggle="collapse"]'
    }, i.prototype.dimension = function() {
        return this.$element.hasClass("width") ? "width" : "height"
    }, i.prototype.show = function() {
        if (!this.transitioning && !this.$element.hasClass("in")) {
            var e, r = this.$parent && this.$parent.children(".panel").children(".in, .collapsing");
            if (!(r && r.length && (e = r.data("bs.collapse")) && e.transitioning)) {
                var o = t.Event("show.bs.collapse");
                if (this.$element.trigger(o), !o.isDefaultPrevented()) {
                    r && r.length && (n.call(r, "hide"), e || r.data("bs.collapse", null));
                    var s = this.dimension();
                    this.$element.removeClass("collapse").addClass("collapsing")[s](0).attr("aria-expanded", !0), this.$trigger.removeClass("collapsed").attr("aria-expanded", !0), this.transitioning = 1;
                    var a = function() {
                        this.$element.removeClass("collapsing").addClass("collapse in")[s](""), this.transitioning = 0, this.$element.trigger("shown.bs.collapse")
                    };
                    if (!t.support.transition) return a.call(this);
                    var l = t.camelCase(["scroll", s].join("-"));
                    this.$element.one("bsTransitionEnd", t.proxy(a, this)).emulateTransitionEnd(i.TRANSITION_DURATION)[s](this.$element[0][l])
                }
            }
        }
    }, i.prototype.hide = function() {
        if (!this.transitioning && this.$element.hasClass("in")) {
            var e = t.Event("hide.bs.collapse");
            if (this.$element.trigger(e), !e.isDefaultPrevented()) {
                var n = this.dimension();
                this.$element[n](this.$element[n]())[0].offsetHeight, this.$element.addClass("collapsing").removeClass("collapse in").attr("aria-expanded", !1), this.$trigger.addClass("collapsed").attr("aria-expanded", !1), this.transitioning = 1;
                var r = function() {
                    this.transitioning = 0, this.$element.removeClass("collapsing").addClass("collapse").trigger("hidden.bs.collapse")
                };
                return t.support.transition ? void this.$element[n](0).one("bsTransitionEnd", t.proxy(r, this)).emulateTransitionEnd(i.TRANSITION_DURATION) : r.call(this)
            }
        }
    }, i.prototype.toggle = function() {
        this[this.$element.hasClass("in") ? "hide" : "show"]()
    }, i.prototype.getParent = function() {
        return t(this.options.parent).find('[data-toggle="collapse"][data-parent="' + this.options.parent + '"]').each(t.proxy(function(n, i) {
            var r = t(i);
            this.addAriaAndCollapsedClass(e(r), r)
        }, this)).end()
    }, i.prototype.addAriaAndCollapsedClass = function(t, e) {
        var n = t.hasClass("in");
        t.attr("aria-expanded", n), e.toggleClass("collapsed", !n).attr("aria-expanded", n)
    };
    var r = t.fn.collapse;
    t.fn.collapse = n, t.fn.collapse.Constructor = i, t.fn.collapse.noConflict = function() {
        return t.fn.collapse = r, this
    }, t(document).on("click.bs.collapse.data-api", '[data-toggle="collapse"]', function(i) {
        var r = t(this);
        r.attr("data-target") || i.preventDefault();
        var o = e(r),
            s = o.data("bs.collapse"),
            a = s ? "toggle" : t.extend({}, r.data(), {
                trigger: this
            });
        n.call(o, a)
    })
}(jQuery),
function(t) {
    "use strict";

    function e(e) {
        e && 3 === e.which || (t(r).remove(), t(o).each(function() {
            var i = t(this),
                r = n(i),
                o = {
                    relatedTarget: this
                };
            r.hasClass("open") && (r.trigger(e = t.Event("hide.bs.dropdown", o)), e.isDefaultPrevented() || (i.attr("aria-expanded", "false"), r.removeClass("open").trigger("hidden.bs.dropdown", o)))
        }))
    }

    function n(e) {
        var n = e.attr("data-target");
        n || (n = e.attr("href"), n = n && /#[A-Za-z]/.test(n) && n.replace(/.*(?=#[^\s]*$)/, ""));
        var i = n && t(n);
        return i && i.length ? i : e.parent()
    }

    function i(e) {
        return this.each(function() {
            var n = t(this),
                i = n.data("bs.dropdown");
            i || n.data("bs.dropdown", i = new s(this)), "string" == typeof e && i[e].call(n)
        })
    }
    var r = ".dropdown-backdrop",
        o = '[data-toggle="dropdown"]',
        s = function(e) {
            t(e).on("click.bs.dropdown", this.toggle)
        };
    s.VERSION = "3.3.2", s.prototype.toggle = function(i) {
        var r = t(this);
        if (!r.is(".disabled, :disabled")) {
            var o = n(r),
                s = o.hasClass("open");
            if (e(), !s) {
                "ontouchstart" in document.documentElement && !o.closest(".navbar-nav").length && t('<div class="dropdown-backdrop"/>').insertAfter(t(this)).on("click", e);
                var a = {
                    relatedTarget: this
                };
                if (o.trigger(i = t.Event("show.bs.dropdown", a)), i.isDefaultPrevented()) return;
                r.trigger("focus").attr("aria-expanded", "true"), o.toggleClass("open").trigger("shown.bs.dropdown", a)
            }
            return !1
        }
    }, s.prototype.keydown = function(e) {
        if (/(38|40|27|32)/.test(e.which) && !/input|textarea/i.test(e.target.tagName)) {
            var i = t(this);
            if (e.preventDefault(), e.stopPropagation(), !i.is(".disabled, :disabled")) {
                var r = n(i),
                    s = r.hasClass("open");
                if (!s && 27 != e.which || s && 27 == e.which) return 27 == e.which && r.find(o).trigger("focus"), i.trigger("click");
                var a = " li:not(.divider):visible a",
                    l = r.find('[role="menu"]' + a + ', [role="listbox"]' + a);
                if (l.length) {
                    var u = l.index(e.target);
                    38 == e.which && u > 0 && u--, 40 == e.which && u < l.length - 1 && u++, ~u || (u = 0), l.eq(u).trigger("focus")
                }
            }
        }
    };
    var a = t.fn.dropdown;
    t.fn.dropdown = i, t.fn.dropdown.Constructor = s, t.fn.dropdown.noConflict = function() {
        return t.fn.dropdown = a, this
    }, t(document).on("click.bs.dropdown.data-api", e).on("click.bs.dropdown.data-api", ".dropdown form", function(t) {
        t.stopPropagation()
    }).on("click.bs.dropdown.data-api", o, s.prototype.toggle).on("keydown.bs.dropdown.data-api", o, s.prototype.keydown).on("keydown.bs.dropdown.data-api", '[role="menu"]', s.prototype.keydown).on("keydown.bs.dropdown.data-api", '[role="listbox"]', s.prototype.keydown)
}(jQuery),
function(t) {
    "use strict";

    function e(e, i) {
        return this.each(function() {
            var r = t(this),
                o = r.data("bs.modal"),
                s = t.extend({}, n.DEFAULTS, r.data(), "object" == typeof e && e);
            o || r.data("bs.modal", o = new n(this, s)), "string" == typeof e ? o[e](i) : s.show && o.show(i)
        })
    }
    var n = function(e, n) {
        this.options = n, this.$body = t(document.body), this.$element = t(e), this.$backdrop = this.isShown = null, this.scrollbarWidth = 0, this.options.remote && this.$element.find(".modal-content").load(this.options.remote, t.proxy(function() {
            this.$element.trigger("loaded.bs.modal")
        }, this))
    };
    n.VERSION = "3.3.2", n.TRANSITION_DURATION = 300, n.BACKDROP_TRANSITION_DURATION = 150, n.DEFAULTS = {
        backdrop: !0,
        keyboard: !0,
        show: !0
    }, n.prototype.toggle = function(t) {
        return this.isShown ? this.hide() : this.show(t)
    }, n.prototype.show = function(e) {
        var i = this,
            r = t.Event("show.bs.modal", {
                relatedTarget: e
            });
        this.$element.trigger(r), this.isShown || r.isDefaultPrevented() || (this.isShown = !0, this.checkScrollbar(), this.setScrollbar(), this.$body.addClass("modal-open"), this.escape(), this.resize(), this.$element.on("click.dismiss.bs.modal", '[data-dismiss="modal"]', t.proxy(this.hide, this)), this.backdrop(function() {
            var r = t.support.transition && i.$element.hasClass("fade");
            i.$element.parent().length || i.$element.appendTo(i.$body), i.$element.show().scrollTop(0), i.options.backdrop && i.adjustBackdrop(), i.adjustDialog(), r && i.$element[0].offsetWidth, i.$element.addClass("in").attr("aria-hidden", !1), i.enforceFocus();
            var o = t.Event("shown.bs.modal", {
                relatedTarget: e
            });
            r ? i.$element.find(".modal-dialog").one("bsTransitionEnd", function() {
                i.$element.trigger("focus").trigger(o)
            }).emulateTransitionEnd(n.TRANSITION_DURATION) : i.$element.trigger("focus").trigger(o)
        }))
    }, n.prototype.hide = function(e) {
        e && e.preventDefault(), e = t.Event("hide.bs.modal"), this.$element.trigger(e), this.isShown && !e.isDefaultPrevented() && (this.isShown = !1, this.escape(), this.resize(), t(document).off("focusin.bs.modal"), this.$element.removeClass("in").attr("aria-hidden", !0).off("click.dismiss.bs.modal"), t.support.transition && this.$element.hasClass("fade") ? this.$element.one("bsTransitionEnd", t.proxy(this.hideModal, this)).emulateTransitionEnd(n.TRANSITION_DURATION) : this.hideModal())
    }, n.prototype.enforceFocus = function() {
        t(document).off("focusin.bs.modal").on("focusin.bs.modal", t.proxy(function(t) {
            this.$element[0] === t.target || this.$element.has(t.target).length || this.$element.trigger("focus")
        }, this))
    }, n.prototype.escape = function() {
        this.isShown && this.options.keyboard ? this.$element.on("keydown.dismiss.bs.modal", t.proxy(function(t) {
            27 == t.which && this.hide()
        }, this)) : this.isShown || this.$element.off("keydown.dismiss.bs.modal")
    }, n.prototype.resize = function() {
        this.isShown ? t(window).on("resize.bs.modal", t.proxy(this.handleUpdate, this)) : t(window).off("resize.bs.modal")
    }, n.prototype.hideModal = function() {
        var t = this;
        this.$element.hide(), this.backdrop(function() {
            t.$body.removeClass("modal-open"), t.resetAdjustments(), t.resetScrollbar(), t.$element.trigger("hidden.bs.modal")
        })
    }, n.prototype.removeBackdrop = function() {
        this.$backdrop && this.$backdrop.remove(), this.$backdrop = null
    }, n.prototype.backdrop = function(e) {
        var i = this,
            r = this.$element.hasClass("fade") ? "fade" : "";
        if (this.isShown && this.options.backdrop) {
            var o = t.support.transition && r;
            if (this.$backdrop = t('<div class="modal-backdrop ' + r + '" />').prependTo(this.$element).on("click.dismiss.bs.modal", t.proxy(function(t) {
                    t.target === t.currentTarget && ("static" == this.options.backdrop ? this.$element[0].focus.call(this.$element[0]) : this.hide.call(this))
                }, this)), o && this.$backdrop[0].offsetWidth, this.$backdrop.addClass("in"), !e) return;
            o ? this.$backdrop.one("bsTransitionEnd", e).emulateTransitionEnd(n.BACKDROP_TRANSITION_DURATION) : e()
        } else if (!this.isShown && this.$backdrop) {
            this.$backdrop.removeClass("in");
            var s = function() {
                i.removeBackdrop(), e && e()
            };
            t.support.transition && this.$element.hasClass("fade") ? this.$backdrop.one("bsTransitionEnd", s).emulateTransitionEnd(n.BACKDROP_TRANSITION_DURATION) : s()
        } else e && e()
    }, n.prototype.handleUpdate = function() {
        this.options.backdrop && this.adjustBackdrop(), this.adjustDialog()
    }, n.prototype.adjustBackdrop = function() {
        this.$backdrop.css("height", 0).css("height", this.$element[0].scrollHeight)
    }, n.prototype.adjustDialog = function() {
        var t = this.$element[0].scrollHeight > document.documentElement.clientHeight;
        this.$element.css({
            paddingLeft: !this.bodyIsOverflowing && t ? this.scrollbarWidth : "",
            paddingRight: this.bodyIsOverflowing && !t ? this.scrollbarWidth : ""
        })
    }, n.prototype.resetAdjustments = function() {
        this.$element.css({
            paddingLeft: "",
            paddingRight: ""
        })
    }, n.prototype.checkScrollbar = function() {
        this.bodyIsOverflowing = document.body.scrollHeight > document.documentElement.clientHeight, this.scrollbarWidth = this.measureScrollbar()
    }, n.prototype.setScrollbar = function() {
        var t = parseInt(this.$body.css("padding-right") || 0, 10);
        this.bodyIsOverflowing && this.$body.css("padding-right", t + this.scrollbarWidth)
    }, n.prototype.resetScrollbar = function() {
        this.$body.css("padding-right", "")
    }, n.prototype.measureScrollbar = function() {
        var t = document.createElement("div");
        t.className = "modal-scrollbar-measure", this.$body.append(t);
        var e = t.offsetWidth - t.clientWidth;
        return this.$body[0].removeChild(t), e
    };
    var i = t.fn.modal;
    t.fn.modal = e, t.fn.modal.Constructor = n, t.fn.modal.noConflict = function() {
        return t.fn.modal = i, this
    }, t(document).on("click.bs.modal.data-api", '[data-toggle="modal"]', function(n) {
        var i = t(this),
            r = i.attr("href"),
            o = t(i.attr("data-target") || r && r.replace(/.*(?=#[^\s]+$)/, "")),
            s = o.data("bs.modal") ? "toggle" : t.extend({
                remote: !/#/.test(r) && r
            }, o.data(), i.data());
        i.is("a") && n.preventDefault(), o.one("show.bs.modal", function(t) {
            t.isDefaultPrevented() || o.one("hidden.bs.modal", function() {
                i.is(":visible") && i.trigger("focus")
            })
        }), e.call(o, s, this)
    })
}(jQuery),
function(t) {
    "use strict";

    function e(e) {
        return this.each(function() {
            var i = t(this),
                r = i.data("bs.tooltip"),
                o = "object" == typeof e && e;
            (r || "destroy" != e) && (r || i.data("bs.tooltip", r = new n(this, o)), "string" == typeof e && r[e]())
        })
    }
    var n = function(t, e) {
        this.type = this.options = this.enabled = this.timeout = this.hoverState = this.$element = null, this.init("tooltip", t, e)
    };
    n.VERSION = "3.3.2", n.TRANSITION_DURATION = 150, n.DEFAULTS = {
        animation: !0,
        placement: "top",
        selector: !1,
        template: '<div class="tooltip" role="tooltip"><div class="tooltip-arrow"></div><div class="tooltip-inner"></div></div>',
        trigger: "hover focus",
        title: "",
        delay: 0,
        html: !1,
        container: !1,
        viewport: {
            selector: "body",
            padding: 0
        }
    }, n.prototype.init = function(e, n, i) {
        this.enabled = !0, this.type = e, this.$element = t(n), this.options = this.getOptions(i), this.$viewport = this.options.viewport && t(this.options.viewport.selector || this.options.viewport);
        for (var r = this.options.trigger.split(" "), o = r.length; o--;) {
            var s = r[o];
            if ("click" == s) this.$element.on("click." + this.type, this.options.selector, t.proxy(this.toggle, this));
            else if ("manual" != s) {
                var a = "hover" == s ? "mouseenter" : "focusin",
                    l = "hover" == s ? "mouseleave" : "focusout";
                this.$element.on(a + "." + this.type, this.options.selector, t.proxy(this.enter, this)), this.$element.on(l + "." + this.type, this.options.selector, t.proxy(this.leave, this))
            }
        }
        this.options.selector ? this._options = t.extend({}, this.options, {
            trigger: "manual",
            selector: ""
        }) : this.fixTitle()
    }, n.prototype.getDefaults = function() {
        return n.DEFAULTS
    }, n.prototype.getOptions = function(e) {
        return e = t.extend({}, this.getDefaults(), this.$element.data(), e), e.delay && "number" == typeof e.delay && (e.delay = {
            show: e.delay,
            hide: e.delay
        }), e
    }, n.prototype.getDelegateOptions = function() {
        var e = {},
            n = this.getDefaults();
        return this._options && t.each(this._options, function(t, i) {
            n[t] != i && (e[t] = i)
        }), e
    }, n.prototype.enter = function(e) {
        var n = e instanceof this.constructor ? e : t(e.currentTarget).data("bs." + this.type);
        return n && n.$tip && n.$tip.is(":visible") ? void(n.hoverState = "in") : (n || (n = new this.constructor(e.currentTarget, this.getDelegateOptions()), t(e.currentTarget).data("bs." + this.type, n)), clearTimeout(n.timeout), n.hoverState = "in", n.options.delay && n.options.delay.show ? void(n.timeout = setTimeout(function() {
            "in" == n.hoverState && n.show()
        }, n.options.delay.show)) : n.show())
    }, n.prototype.leave = function(e) {
        var n = e instanceof this.constructor ? e : t(e.currentTarget).data("bs." + this.type);
        return n || (n = new this.constructor(e.currentTarget, this.getDelegateOptions()), t(e.currentTarget).data("bs." + this.type, n)), clearTimeout(n.timeout), n.hoverState = "out", n.options.delay && n.options.delay.hide ? void(n.timeout = setTimeout(function() {
            "out" == n.hoverState && n.hide()
        }, n.options.delay.hide)) : n.hide()
    }, n.prototype.show = function() {
        var e = t.Event("show.bs." + this.type);
        if (this.hasContent() && this.enabled) {
            this.$element.trigger(e);
            var i = t.contains(this.$element[0].ownerDocument.documentElement, this.$element[0]);
            if (e.isDefaultPrevented() || !i) return;
            var r = this,
                o = this.tip(),
                s = this.getUID(this.type);
            this.setContent(), o.attr("id", s), this.$element.attr("aria-describedby", s), this.options.animation && o.addClass("fade");
            var a = "function" == typeof this.options.placement ? this.options.placement.call(this, o[0], this.$element[0]) : this.options.placement,
                l = /\s?auto?\s?/i,
                u = l.test(a);
            u && (a = a.replace(l, "") || "top"), o.detach().css({
                top: 0,
                left: 0,
                display: "block"
            }).addClass(a).data("bs." + this.type, this), this.options.container ? o.appendTo(this.options.container) : o.insertAfter(this.$element);
            var c = this.getPosition(),
                h = o[0].offsetWidth,
                d = o[0].offsetHeight;
            if (u) {
                var f = a,
                    p = this.options.container ? t(this.options.container) : this.$element.parent(),
                    m = this.getPosition(p);
                a = "bottom" == a && c.bottom + d > m.bottom ? "top" : "top" == a && c.top - d < m.top ? "bottom" : "right" == a && c.right + h > m.width ? "left" : "left" == a && c.left - h < m.left ? "right" : a, o.removeClass(f).addClass(a)
            }
            var g = this.getCalculatedOffset(a, c, h, d);
            this.applyPlacement(g, a);
            var v = function() {
                var t = r.hoverState;
                r.$element.trigger("shown.bs." + r.type), r.hoverState = null, "out" == t && r.leave(r)
            };
            t.support.transition && this.$tip.hasClass("fade") ? o.one("bsTransitionEnd", v).emulateTransitionEnd(n.TRANSITION_DURATION) : v()
        }
    }, n.prototype.applyPlacement = function(e, n) {
        var i = this.tip(),
            r = i[0].offsetWidth,
            o = i[0].offsetHeight,
            s = parseInt(i.css("margin-top"), 10),
            a = parseInt(i.css("margin-left"), 10);
        isNaN(s) && (s = 0), isNaN(a) && (a = 0), e.top = e.top + s, e.left = e.left + a, t.offset.setOffset(i[0], t.extend({
            using: function(t) {
                i.css({
                    top: Math.round(t.top),
                    left: Math.round(t.left)
                })
            }
        }, e), 0), i.addClass("in");
        var l = i[0].offsetWidth,
            u = i[0].offsetHeight;
        "top" == n && u != o && (e.top = e.top + o - u);
        var c = this.getViewportAdjustedDelta(n, e, l, u);
        c.left ? e.left += c.left : e.top += c.top;
        var h = /top|bottom/.test(n),
            d = h ? 2 * c.left - r + l : 2 * c.top - o + u,
            f = h ? "offsetWidth" : "offsetHeight";
        i.offset(e), this.replaceArrow(d, i[0][f], h)
    }, n.prototype.replaceArrow = function(t, e, n) {
        this.arrow().css(n ? "left" : "top", 50 * (1 - t / e) + "%").css(n ? "top" : "left", "")
    }, n.prototype.setContent = function() {
        var t = this.tip(),
            e = this.getTitle();
        t.find(".tooltip-inner")[this.options.html ? "html" : "text"](e), t.removeClass("fade in top bottom left right")
    }, n.prototype.hide = function(e) {
        function i() {
            "in" != r.hoverState && o.detach(), r.$element.removeAttr("aria-describedby").trigger("hidden.bs." + r.type), e && e()
        }
        var r = this,
            o = this.tip(),
            s = t.Event("hide.bs." + this.type);
        return this.$element.trigger(s), s.isDefaultPrevented() ? void 0 : (o.removeClass("in"), t.support.transition && this.$tip.hasClass("fade") ? o.one("bsTransitionEnd", i).emulateTransitionEnd(n.TRANSITION_DURATION) : i(), this.hoverState = null, this)
    }, n.prototype.fixTitle = function() {
        var t = this.$element;
        (t.attr("title") || "string" != typeof t.attr("data-original-title")) && t.attr("data-original-title", t.attr("title") || "").attr("title", "")
    }, n.prototype.hasContent = function() {
        return this.getTitle()
    }, n.prototype.getPosition = function(e) {
        e = e || this.$element;
        var n = e[0],
            i = "BODY" == n.tagName,
            r = n.getBoundingClientRect();
        null == r.width && (r = t.extend({}, r, {
            width: r.right - r.left,
            height: r.bottom - r.top
        }));
        var o = i ? {
                top: 0,
                left: 0
            } : e.offset(),
            s = {
                scroll: i ? document.documentElement.scrollTop || document.body.scrollTop : e.scrollTop()
            },
            a = i ? {
                width: t(window).width(),
                height: t(window).height()
            } : null;
        return t.extend({}, r, s, a, o)
    }, n.prototype.getCalculatedOffset = function(t, e, n, i) {
        return "bottom" == t ? {
            top: e.top + e.height,
            left: e.left + e.width / 2 - n / 2
        } : "top" == t ? {
            top: e.top - i,
            left: e.left + e.width / 2 - n / 2
        } : "left" == t ? {
            top: e.top + e.height / 2 - i / 2,
            left: e.left - n
        } : {
            top: e.top + e.height / 2 - i / 2,
            left: e.left + e.width
        }
    }, n.prototype.getViewportAdjustedDelta = function(t, e, n, i) {
        var r = {
            top: 0,
            left: 0
        };
        if (!this.$viewport) return r;
        var o = this.options.viewport && this.options.viewport.padding || 0,
            s = this.getPosition(this.$viewport);
        if (/right|left/.test(t)) {
            var a = e.top - o - s.scroll,
                l = e.top + o - s.scroll + i;
            a < s.top ? r.top = s.top - a : l > s.top + s.height && (r.top = s.top + s.height - l)
        } else {
            var u = e.left - o,
                c = e.left + o + n;
            u < s.left ? r.left = s.left - u : c > s.width && (r.left = s.left + s.width - c)
        }
        return r
    }, n.prototype.getTitle = function() {
        var t = this.$element,
            e = this.options;
        return t.attr("data-original-title") || ("function" == typeof e.title ? e.title.call(t[0]) : e.title)
    }, n.prototype.getUID = function(t) {
        do {
            t += ~~(1e6 * Math.random())
        } while (document.getElementById(t));
        return t
    }, n.prototype.tip = function() {
        return this.$tip = this.$tip || t(this.options.template)
    }, n.prototype.arrow = function() {
        return this.$arrow = this.$arrow || this.tip().find(".tooltip-arrow")
    }, n.prototype.enable = function() {
        this.enabled = !0
    }, n.prototype.disable = function() {
        this.enabled = !1
    }, n.prototype.toggleEnabled = function() {
        this.enabled = !this.enabled
    }, n.prototype.toggle = function(e) {
        var n = this;
        e && ((n = t(e.currentTarget).data("bs." + this.type)) || (n = new this.constructor(e.currentTarget, this.getDelegateOptions()), t(e.currentTarget).data("bs." + this.type, n))), n.tip().hasClass("in") ? n.leave(n) : n.enter(n)
    }, n.prototype.destroy = function() {
        var t = this;
        clearTimeout(this.timeout), this.hide(function() {
            t.$element.off("." + t.type).removeData("bs." + t.type)
        })
    };
    var i = t.fn.tooltip;
    t.fn.tooltip = e, t.fn.tooltip.Constructor = n, t.fn.tooltip.noConflict = function() {
        return t.fn.tooltip = i, this
    }
}(jQuery),
function(t) {
    "use strict";

    function e(e) {
        return this.each(function() {
            var i = t(this),
                r = i.data("bs.popover"),
                o = "object" == typeof e && e;
            (r || "destroy" != e) && (r || i.data("bs.popover", r = new n(this, o)), "string" == typeof e && r[e]())
        })
    }
    var n = function(t, e) {
        this.init("popover", t, e)
    };
    if (!t.fn.tooltip) throw new Error("Popover requires tooltip.js");
    n.VERSION = "3.3.2", n.DEFAULTS = t.extend({}, t.fn.tooltip.Constructor.DEFAULTS, {
        placement: "right",
        trigger: "click",
        content: "",
        template: '<div class="popover" role="tooltip"><div class="arrow"></div><h3 class="popover-title"></h3><div class="popover-content"></div></div>'
    }), n.prototype = t.extend({}, t.fn.tooltip.Constructor.prototype), n.prototype.constructor = n, n.prototype.getDefaults = function() {
        return n.DEFAULTS
    }, n.prototype.setContent = function() {
        var t = this.tip(),
            e = this.getTitle(),
            n = this.getContent();
        t.find(".popover-title")[this.options.html ? "html" : "text"](e), t.find(".popover-content").children().detach().end()[this.options.html ? "string" == typeof n ? "html" : "append" : "text"](n), t.removeClass("fade top bottom left right in"), t.find(".popover-title").html() || t.find(".popover-title").hide()
    }, n.prototype.hasContent = function() {
        return this.getTitle() || this.getContent()
    }, n.prototype.getContent = function() {
        var t = this.$element,
            e = this.options;
        return t.attr("data-content") || ("function" == typeof e.content ? e.content.call(t[0]) : e.content)
    }, n.prototype.arrow = function() {
        return this.$arrow = this.$arrow || this.tip().find(".arrow")
    }, n.prototype.tip = function() {
        return this.$tip || (this.$tip = t(this.options.template)), this.$tip
    };
    var i = t.fn.popover;
    t.fn.popover = e, t.fn.popover.Constructor = n, t.fn.popover.noConflict = function() {
        return t.fn.popover = i, this
    }
}(jQuery),
function(t) {
    "use strict";

    function e(n, i) {
        var r = t.proxy(this.process, this);
        this.$body = t("body"), this.$scrollElement = t(t(n).is("body") ? window : n), this.options = t.extend({}, e.DEFAULTS, i), this.selector = (this.options.target || "") + " .nav li > a", this.offsets = [], this.targets = [], this.activeTarget = null, this.scrollHeight = 0, this.$scrollElement.on("scroll.bs.scrollspy", r), this.refresh(), this.process()
    }

    function n(n) {
        return this.each(function() {
            var i = t(this),
                r = i.data("bs.scrollspy"),
                o = "object" == typeof n && n;
            r || i.data("bs.scrollspy", r = new e(this, o)), "string" == typeof n && r[n]()
        })
    }
    e.VERSION = "3.3.2", e.DEFAULTS = {
        offset: 10
    }, e.prototype.getScrollHeight = function() {
        return this.$scrollElement[0].scrollHeight || Math.max(this.$body[0].scrollHeight, document.documentElement.scrollHeight)
    }, e.prototype.refresh = function() {
        var e = "offset",
            n = 0;
        t.isWindow(this.$scrollElement[0]) || (e = "position", n = this.$scrollElement.scrollTop()), this.offsets = [], this.targets = [], this.scrollHeight = this.getScrollHeight();
        var i = this;
        this.$body.find(this.selector).map(function() {
            var i = t(this),
                r = i.data("target") || i.attr("href"),
                o = /^#./.test(r) && t(r);
            return o && o.length && o.is(":visible") && [
                [o[e]().top + n, r]
            ] || null
        }).sort(function(t, e) {
            return t[0] - e[0]
        }).each(function() {
            i.offsets.push(this[0]), i.targets.push(this[1])
        })
    }, e.prototype.process = function() {
        var t, e = this.$scrollElement.scrollTop() + this.options.offset,
            n = this.getScrollHeight(),
            i = this.options.offset + n - this.$scrollElement.height(),
            r = this.offsets,
            o = this.targets,
            s = this.activeTarget;
        if (this.scrollHeight != n && this.refresh(), e >= i) return s != (t = o[o.length - 1]) && this.activate(t);
        if (s && e < r[0]) return this.activeTarget = null, this.clear();
        for (t = r.length; t--;) s != o[t] && e >= r[t] && (!r[t + 1] || e <= r[t + 1]) && this.activate(o[t])
    }, e.prototype.activate = function(e) {
        this.activeTarget = e, this.clear();
        var n = this.selector + '[data-target="' + e + '"],' + this.selector + '[href="' + e + '"]',
            i = t(n).parents("li").addClass("active");
        i.parent(".dropdown-menu").length && (i = i.closest("li.dropdown").addClass("active")), i.trigger("activate.bs.scrollspy")
    }, e.prototype.clear = function() {
        t(this.selector).parentsUntil(this.options.target, ".active").removeClass("active")
    };
    var i = t.fn.scrollspy;
    t.fn.scrollspy = n, t.fn.scrollspy.Constructor = e, t.fn.scrollspy.noConflict = function() {
        return t.fn.scrollspy = i, this
    }, t(window).on("load.bs.scrollspy.data-api", function() {
        t('[data-spy="scroll"]').each(function() {
            var e = t(this);
            n.call(e, e.data())
        })
    })
}(jQuery),
function(t) {
    "use strict";

    function e(e) {
        return this.each(function() {
            var i = t(this),
                r = i.data("bs.tab");
            r || i.data("bs.tab", r = new n(this)), "string" == typeof e && r[e]()
        })
    }
    var n = function(e) {
        this.element = t(e)
    };
    n.VERSION = "3.3.2", n.TRANSITION_DURATION = 150, n.prototype.show = function() {
        var e = this.element,
            n = e.closest("ul:not(.dropdown-menu)"),
            i = e.data("target");
        if (i || (i = e.attr("href"), i = i && i.replace(/.*(?=#[^\s]*$)/, "")), !e.parent("li").hasClass("active")) {
            var r = n.find(".active:last a"),
                o = t.Event("hide.bs.tab", {
                    relatedTarget: e[0]
                }),
                s = t.Event("show.bs.tab", {
                    relatedTarget: r[0]
                });
            if (r.trigger(o), e.trigger(s), !s.isDefaultPrevented() && !o.isDefaultPrevented()) {
                var a = t(i);
                this.activate(e.closest("li"), n), this.activate(a, a.parent(), function() {
                    r.trigger({
                        type: "hidden.bs.tab",
                        relatedTarget: e[0]
                    }), e.trigger({
                        type: "shown.bs.tab",
                        relatedTarget: r[0]
                    })
                })
            }
        }
    }, n.prototype.activate = function(e, i, r) {
        function o() {
            s.removeClass("active").find("> .dropdown-menu > .active").removeClass("active").end().find('[data-toggle="tab"]').attr("aria-expanded", !1), e.addClass("active").find('[data-toggle="tab"]').attr("aria-expanded", !0), a ? (e[0].offsetWidth, e.addClass("in")) : e.removeClass("fade"), e.parent(".dropdown-menu") && e.closest("li.dropdown").addClass("active").end().find('[data-toggle="tab"]').attr("aria-expanded", !0), r && r()
        }
        var s = i.find("> .active"),
            a = r && t.support.transition && (s.length && s.hasClass("fade") || !!i.find("> .fade").length);
        s.length && a ? s.one("bsTransitionEnd", o).emulateTransitionEnd(n.TRANSITION_DURATION) : o(), s.removeClass("in")
    };
    var i = t.fn.tab;
    t.fn.tab = e, t.fn.tab.Constructor = n, t.fn.tab.noConflict = function() {
        return t.fn.tab = i, this
    };
    var r = function(n) {
        n.preventDefault(), e.call(t(this), "show")
    };
    t(document).on("click.bs.tab.data-api", '[data-toggle="tab"]', r).on("click.bs.tab.data-api", '[data-toggle="pill"]', r)
}(jQuery),
function(t) {
    "use strict";

    function e(e) {
        return this.each(function() {
            var i = t(this),
                r = i.data("bs.affix"),
                o = "object" == typeof e && e;
            r || i.data("bs.affix", r = new n(this, o)), "string" == typeof e && r[e]()
        })
    }
    var n = function(e, i) {
        this.options = t.extend({}, n.DEFAULTS, i), this.$target = t(this.options.target).on("scroll.bs.affix.data-api", t.proxy(this.checkPosition, this)).on("click.bs.affix.data-api", t.proxy(this.checkPositionWithEventLoop, this)), this.$element = t(e), this.affixed = this.unpin = this.pinnedOffset = null, this.checkPosition()
    };
    n.VERSION = "3.3.2", n.RESET = "affix affix-top affix-bottom", n.DEFAULTS = {
        offset: 0,
        target: window
    }, n.prototype.getState = function(t, e, n, i) {
        var r = this.$target.scrollTop(),
            o = this.$element.offset(),
            s = this.$target.height();
        if (null != n && "top" == this.affixed) return n > r && "top";
        if ("bottom" == this.affixed) return null != n ? !(r + this.unpin <= o.top) && "bottom" : !(t - i >= r + s) && "bottom";
        var a = null == this.affixed,
            l = a ? r : o.top,
            u = a ? s : e;
        return null != n && n >= r ? "top" : null != i && l + u >= t - i && "bottom"
    }, n.prototype.getPinnedOffset = function() {
        if (this.pinnedOffset) return this.pinnedOffset;
        this.$element.removeClass(n.RESET).addClass("affix");
        var t = this.$target.scrollTop(),
            e = this.$element.offset();
        return this.pinnedOffset = e.top - t
    }, n.prototype.checkPositionWithEventLoop = function() {
        setTimeout(t.proxy(this.checkPosition, this), 1)
    }, n.prototype.checkPosition = function() {
        if (this.$element.is(":visible")) {
            var e = this.$element.height(),
                i = this.options.offset,
                r = i.top,
                o = i.bottom,
                s = t("body").height();
            "object" != typeof i && (o = r = i), "function" == typeof r && (r = i.top(this.$element)), "function" == typeof o && (o = i.bottom(this.$element));
            var a = this.getState(s, e, r, o);
            if (this.affixed != a) {
                null != this.unpin && this.$element.css("top", "");
                var l = "affix" + (a ? "-" + a : ""),
                    u = t.Event(l + ".bs.affix");
                if (this.$element.trigger(u), u.isDefaultPrevented()) return;
                this.affixed = a, this.unpin = "bottom" == a ? this.getPinnedOffset() : null, this.$element.removeClass(n.RESET).addClass(l).trigger(l.replace("affix", "affixed") + ".bs.affix")
            }
            "bottom" == a && this.$element.offset({
                top: s - e - o
            })
        }
    };
    var i = t.fn.affix;
    t.fn.affix = e, t.fn.affix.Constructor = n, t.fn.affix.noConflict = function() {
        return t.fn.affix = i, this
    }, t(window).on("load", function() {
        t('[data-spy="affix"]').each(function() {
            var n = t(this),
                i = n.data();
            i.offset = i.offset || {}, null != i.offsetBottom && (i.offset.bottom = i.offsetBottom), null != i.offsetTop && (i.offset.top = i.offsetTop), e.call(n, i)
        })
    })
}(jQuery),
function(t, e) {
    if ("function" == typeof define && define.amd) define(["jquery"], e);
    else if ("object" == typeof module && module.exports) {
        var n;
        try {
            n = require("jquery")
        } catch (t) {
            n = null
        }
        module.exports = e(n)
    } else t.Slider = e(t.jQuery)
}(this, function(t) {
    var e;
    return function(t) {
            "use strict";

            function e() {}
            var n = Array.prototype.slice;
            ! function(t) {
                function i(e) {
                    e.prototype.option || (e.prototype.option = function(e) {
                        t.isPlainObject(e) && (this.options = t.extend(!0, this.options, e))
                    })
                }

                function r(e, i) {
                    t.fn[e] = function(r) {
                        if ("string" == typeof r) {
                            for (var s = n.call(arguments, 1), a = 0, l = this.length; l > a; a++) {
                                var u = this[a],
                                    c = t.data(u, e);
                                if (c)
                                    if (t.isFunction(c[r]) && "_" !== r.charAt(0)) {
                                        var h = c[r].apply(c, s);
                                        if (void 0 !== h && h !== c) return h
                                    } else o("no such method '" + r + "' for " + e + " instance");
                                else o("cannot call methods on " + e + " prior to initialization; attempted to call '" + r + "'")
                            }
                            return this
                        }
                        var d = this.map(function() {
                            var n = t.data(this, e);
                            return n ? (n.option(r), n._init()) : (n = new i(this, r), t.data(this, e, n)), t(this)
                        });
                        return !d || d.length > 1 ? d : d[0]
                    }
                }
                if (t) {
                    var o = "undefined" == typeof console ? e : function(t) {
                        console.error(t)
                    };
                    t.bridget = function(t, e) {
                        i(e), r(t, e)
                    }, t.bridget
                }
            }(t)
        }(t),
        function(t) {
            function n(e, n) {
                "string" == typeof e ? this.element = document.querySelector(e) : e instanceof HTMLElement && (this.element = e), n = n || {};
                for (var i = Object.keys(this.defaultOptions), o = 0; o < i.length; o++) {
                    var s = i[o],
                        a = n[s];
                    a = void 0 !== a ? a : function(t, e) {
                        var n = "data-slider-" + e.replace(/_/g, "-"),
                            i = t.getAttribute(n);
                        try {
                            return JSON.parse(i)
                        } catch (t) {
                            return i
                        }
                    }(this.element, s), a = null !== a ? a : this.defaultOptions[s], this.options || (this.options = {}), this.options[s] = a
                }
                var l, u, c, h, d, f = this.element.style.width,
                    p = !1,
                    m = this.element.parentNode;
                if (this.sliderElem) p = !0;
                else {
                    this.sliderElem = document.createElement("div"), this.sliderElem.className = "slider";
                    var g = document.createElement("div");
                    if (g.className = "slider-track", u = document.createElement("div"), u.className = "slider-track-low", l = document.createElement("div"), l.className = "slider-selection", c = document.createElement("div"), c.className = "slider-track-high", h = document.createElement("div"), h.className = "slider-handle min-slider-handle", d = document.createElement("div"), d.className = "slider-handle max-slider-handle", g.appendChild(u), g.appendChild(l), g.appendChild(c), this.ticks = [], Array.isArray(this.options.ticks) && this.options.ticks.length > 0) {
                        for (o = 0; o < this.options.ticks.length; o++) {
                            var v = document.createElement("div");
                            v.className = "slider-tick", this.ticks.push(v), g.appendChild(v)
                        }
                        l.className += " tick-slider-selection"
                    }
                    if (g.appendChild(h), g.appendChild(d), this.tickLabels = [], Array.isArray(this.options.ticks_labels) && this.options.ticks_labels.length > 0)
                        for (this.tickLabelContainer = document.createElement("div"), this.tickLabelContainer.className = "slider-tick-label-container", o = 0; o < this.options.ticks_labels.length; o++) {
                            var y = document.createElement("div");
                            y.className = "slider-tick-label", y.innerHTML = this.options.ticks_labels[o], this.tickLabels.push(y), this.tickLabelContainer.appendChild(y)
                        }
                    var b = function(t) {
                            var e = document.createElement("div");
                            e.className = "tooltip-arrow";
                            var n = document.createElement("div");
                            n.className = "tooltip-inner", t.appendChild(e), t.appendChild(n)
                        },
                        _ = document.createElement("div");
                    _.className = "tooltip tooltip-main", b(_);
                    var w = document.createElement("div");
                    w.className = "tooltip tooltip-min", b(w);
                    var x = document.createElement("div");
                    x.className = "tooltip tooltip-max", b(x), this.sliderElem.appendChild(g), this.sliderElem.appendChild(_), this.sliderElem.appendChild(w), this.sliderElem.appendChild(x), this.tickLabelContainer && this.sliderElem.appendChild(this.tickLabelContainer), m.insertBefore(this.sliderElem, this.element), this.element.style.display = "none"
                }
                if (t && (this.$element = t(this.element), this.$sliderElem = t(this.sliderElem)), this.eventToCallbackMap = {}, this.sliderElem.id = this.options.id, this.touchCapable = "ontouchstart" in window || window.DocumentTouch && document instanceof window.DocumentTouch, this.tooltip = this.sliderElem.querySelector(".tooltip-main"), this.tooltipInner = this.tooltip.querySelector(".tooltip-inner"), this.tooltip_min = this.sliderElem.querySelector(".tooltip-min"), this.tooltipInner_min = this.tooltip_min.querySelector(".tooltip-inner"), this.tooltip_max = this.sliderElem.querySelector(".tooltip-max"), this.tooltipInner_max = this.tooltip_max.querySelector(".tooltip-inner"), r[this.options.scale] && (this.options.scale = r[this.options.scale]), !0 === p && (this._removeClass(this.sliderElem, "slider-horizontal"), this._removeClass(this.sliderElem, "slider-vertical"), this._removeClass(this.tooltip, "hide"), this._removeClass(this.tooltip_min, "hide"), this._removeClass(this.tooltip_max, "hide"), ["left", "top", "width", "height"].forEach(function(t) {
                        this._removeProperty(this.trackLow, t), this._removeProperty(this.trackSelection, t), this._removeProperty(this.trackHigh, t)
                    }, this), [this.handle1, this.handle2].forEach(function(t) {
                        this._removeProperty(t, "left"), this._removeProperty(t, "top")
                    }, this), [this.tooltip, this.tooltip_min, this.tooltip_max].forEach(function(t) {
                        this._removeProperty(t, "left"), this._removeProperty(t, "top"), this._removeProperty(t, "margin-left"), this._removeProperty(t, "margin-top"), this._removeClass(t, "right"), this._removeClass(t, "top")
                    }, this)), "vertical" === this.options.orientation ? (this._addClass(this.sliderElem, "slider-vertical"), this.stylePos = "top", this.mousePos = "pageY", this.sizePos = "offsetHeight", this._addClass(this.tooltip, "right"), this.tooltip.style.left = "100%", this._addClass(this.tooltip_min, "right"), this.tooltip_min.style.left = "100%", this._addClass(this.tooltip_max, "right"), this.tooltip_max.style.left = "100%") : (this._addClass(this.sliderElem, "slider-horizontal"), this.sliderElem.style.width = f, this.options.orientation = "horizontal", this.stylePos = "left", this.mousePos = "pageX", this.sizePos = "offsetWidth", this._addClass(this.tooltip, "top"), this.tooltip.style.top = -this.tooltip.outerHeight - 14 + "px", this._addClass(this.tooltip_min, "top"), this.tooltip_min.style.top = -this.tooltip_min.outerHeight - 14 + "px", this._addClass(this.tooltip_max, "top"), this.tooltip_max.style.top = -this.tooltip_max.outerHeight - 14 + "px"), Array.isArray(this.options.ticks) && this.options.ticks.length > 0 && (this.options.max = Math.max.apply(Math, this.options.ticks), this.options.min = Math.min.apply(Math, this.options.ticks)), Array.isArray(this.options.value) ? this.options.range = !0 : this.options.range && (this.options.value = [this.options.value, this.options.max]), this.trackLow = u || this.trackLow, this.trackSelection = l || this.trackSelection, this.trackHigh = c || this.trackHigh, "none" === this.options.selection && (this._addClass(this.trackLow, "hide"), this._addClass(this.trackSelection, "hide"), this._addClass(this.trackHigh, "hide")), this.handle1 = h || this.handle1, this.handle2 = d || this.handle2, !0 === p)
                    for (this._removeClass(this.handle1, "round triangle"), this._removeClass(this.handle2, "round triangle hide"), o = 0; o < this.ticks.length; o++) this._removeClass(this.ticks[o], "round triangle hide");
                if (-1 !== ["round", "triangle", "custom"].indexOf(this.options.handle))
                    for (this._addClass(this.handle1, this.options.handle), this._addClass(this.handle2, this.options.handle), o = 0; o < this.ticks.length; o++) this._addClass(this.ticks[o], this.options.handle);
                this.offset = this._offset(this.sliderElem), this.size = this.sliderElem[this.sizePos], this.setValue(this.options.value), this.handle1Keydown = this._keydown.bind(this, 0), this.handle1.addEventListener("keydown", this.handle1Keydown, !1), this.handle2Keydown = this._keydown.bind(this, 1), this.handle2.addEventListener("keydown", this.handle2Keydown, !1), this.mousedown = this._mousedown.bind(this), this.touchCapable && this.sliderElem.addEventListener("touchstart", this.mousedown, !1), this.sliderElem.addEventListener("mousedown", this.mousedown, !1), "hide" === this.options.tooltip ? (this._addClass(this.tooltip, "hide"), this._addClass(this.tooltip_min, "hide"), this._addClass(this.tooltip_max, "hide")) : "always" === this.options.tooltip ? (this._showTooltip(), this._alwaysShowTooltip = !0) : (this.showTooltip = this._showTooltip.bind(this), this.hideTooltip = this._hideTooltip.bind(this), this.sliderElem.addEventListener("mouseenter", this.showTooltip, !1), this.sliderElem.addEventListener("mouseleave", this.hideTooltip, !1), this.handle1.addEventListener("focus", this.showTooltip, !1), this.handle1.addEventListener("blur", this.hideTooltip, !1), this.handle2.addEventListener("focus", this.showTooltip, !1), this.handle2.addEventListener("blur", this.hideTooltip, !1)), this.options.enabled ? this.enable() : this.disable()
            }
            var i = {
                    formatInvalidInputErrorMsg: function(t) {
                        return "Invalid input value '" + t + "' passed in"
                    },
                    callingContextNotSliderInstance: "Calling context element does not have instance of Slider bound to it. Check your code to make sure the JQuery object returned from the call to the slider() initializer is calling the method"
                },
                r = {
                    linear: {
                        toValue: function(t) {
                            var e = t / 100 * (this.options.max - this.options.min);
                            if (this.options.ticks_positions.length > 0) {
                                for (var n, i, r, o = 0, s = 0; s < this.options.ticks_positions.length; s++)
                                    if (t <= this.options.ticks_positions[s]) {
                                        n = s > 0 ? this.options.ticks[s - 1] : 0, r = s > 0 ? this.options.ticks_positions[s - 1] : 0, i = this.options.ticks[s], o = this.options.ticks_positions[s];
                                        break
                                    } if (s > 0) {
                                    e = n + (t - r) / (o - r) * (i - n)
                                }
                            }
                            var a = this.options.min + Math.round(e / this.options.step) * this.options.step;
                            return a < this.options.min ? this.options.min : a > this.options.max ? this.options.max : a
                        },
                        toPercentage: function(t) {
                            if (this.options.max === this.options.min) return 0;
                            if (this.options.ticks_positions.length > 0) {
                                for (var e, n, i, r = 0, o = 0; o < this.options.ticks.length; o++)
                                    if (t <= this.options.ticks[o]) {
                                        e = o > 0 ? this.options.ticks[o - 1] : 0, i = o > 0 ? this.options.ticks_positions[o - 1] : 0, n = this.options.ticks[o], r = this.options.ticks_positions[o];
                                        break
                                    } if (o > 0) {
                                    return i + (t - e) / (n - e) * (r - i)
                                }
                            }
                            return 100 * (t - this.options.min) / (this.options.max - this.options.min)
                        }
                    },
                    logarithmic: {
                        toValue: function(t) {
                            var e = 0 === this.options.min ? 0 : Math.log(this.options.min),
                                n = Math.log(this.options.max),
                                i = Math.exp(e + (n - e) * t / 100);
                            return i = this.options.min + Math.round((i - this.options.min) / this.options.step) * this.options.step, i < this.options.min ? this.options.min : i > this.options.max ? this.options.max : i
                        },
                        toPercentage: function(t) {
                            if (this.options.max === this.options.min) return 0;
                            var e = Math.log(this.options.max),
                                n = 0 === this.options.min ? 0 : Math.log(this.options.min);
                            return 100 * ((0 === t ? 0 : Math.log(t)) - n) / (e - n)
                        }
                    }
                };
            if (e = function(t, e) {
                    return n.call(this, t, e), this
                }, e.prototype = {
                    _init: function() {},
                    constructor: e,
                    defaultOptions: {
                        id: "",
                        min: 0,
                        max: 10,
                        step: 1,
                        precision: 0,
                        orientation: "horizontal",
                        value: 5,
                        range: !1,
                        selection: "before",
                        tooltip: "show",
                        tooltip_split: !1,
                        handle: "round",
                        reversed: !1,
                        enabled: !0,
                        formatter: function(t) {
                            return Array.isArray(t) ? t[0] + " : " + t[1] : t
                        },
                        natural_arrow_keys: !1,
                        ticks: [],
                        ticks_positions: [],
                        ticks_labels: [],
                        ticks_snap_bounds: 0,
                        scale: "linear",
                        focus: !1
                    },
                    over: !1,
                    inDrag: !1,
                    getValue: function() {
                        return this.options.range ? this.options.value : this.options.value[0]
                    },
                    setValue: function(t, e, n) {
                        t || (t = 0);
                        var i = this.getValue();
                        this.options.value = this._validateInputValue(t);
                        var r = this._applyPrecision.bind(this);
                        this.options.range ? (this.options.value[0] = r(this.options.value[0]), this.options.value[1] = r(this.options.value[1]), this.options.value[0] = Math.max(this.options.min, Math.min(this.options.max, this.options.value[0])), this.options.value[1] = Math.max(this.options.min, Math.min(this.options.max, this.options.value[1]))) : (this.options.value = r(this.options.value), this.options.value = [Math.max(this.options.min, Math.min(this.options.max, this.options.value))], this._addClass(this.handle2, "hide"), this.options.value[1] = "after" === this.options.selection ? this.options.max : this.options.min), this.percentage = this.options.max > this.options.min ? [this._toPercentage(this.options.value[0]), this._toPercentage(this.options.value[1]), 100 * this.options.step / (this.options.max - this.options.min)] : [0, 0, 100], this._layout();
                        var o = this.options.range ? this.options.value : this.options.value[0];
                        return !0 === e && this._trigger("slide", o), i !== o && !0 === n && this._trigger("change", {
                            oldValue: i,
                            newValue: o
                        }), this._setDataVal(o), this
                    },
                    destroy: function() {
                        this._removeSliderEventHandlers(), this.sliderElem.parentNode.removeChild(this.sliderElem), this.element.style.display = "", this._cleanUpEventCallbacksMap(), this.element.removeAttribute("data"), t && (this._unbindJQueryEventHandlers(), this.$element.removeData("slider"))
                    },
                    disable: function() {
                        return this.options.enabled = !1, this.handle1.removeAttribute("tabindex"), this.handle2.removeAttribute("tabindex"), this._addClass(this.sliderElem, "slider-disabled"), this._trigger("slideDisabled"), this
                    },
                    enable: function() {
                        return this.options.enabled = !0, this.handle1.setAttribute("tabindex", 0), this.handle2.setAttribute("tabindex", 0), this._removeClass(this.sliderElem, "slider-disabled"), this._trigger("slideEnabled"), this
                    },
                    toggle: function() {
                        return this.options.enabled ? this.disable() : this.enable(), this
                    },
                    isEnabled: function() {
                        return this.options.enabled
                    },
                    on: function(t, e) {
                        return this._bindNonQueryEventHandler(t, e), this
                    },
                    getAttribute: function(t) {
                        return t ? this.options[t] : this.options
                    },
                    setAttribute: function(t, e) {
                        return this.options[t] = e, this
                    },
                    refresh: function() {
                        return this._removeSliderEventHandlers(), n.call(this, this.element, this.options), t && t.data(this.element, "slider", this), this
                    },
                    relayout: function() {
                        return this._layout(), this
                    },
                    _removeSliderEventHandlers: function() {
                        this.handle1.removeEventListener("keydown", this.handle1Keydown, !1), this.handle1.removeEventListener("focus", this.showTooltip, !1), this.handle1.removeEventListener("blur", this.hideTooltip, !1), this.handle2.removeEventListener("keydown", this.handle2Keydown, !1), this.handle2.removeEventListener("focus", this.handle2Keydown, !1), this.handle2.removeEventListener("blur", this.handle2Keydown, !1), this.sliderElem.removeEventListener("mouseenter", this.showTooltip, !1), this.sliderElem.removeEventListener("mouseleave", this.hideTooltip, !1), this.sliderElem.removeEventListener("touchstart", this.mousedown, !1), this.sliderElem.removeEventListener("mousedown", this.mousedown, !1)
                    },
                    _bindNonQueryEventHandler: function(t, e) {
                        void 0 === this.eventToCallbackMap[t] && (this.eventToCallbackMap[t] = []), this.eventToCallbackMap[t].push(e)
                    },
                    _cleanUpEventCallbacksMap: function() {
                        for (var t = Object.keys(this.eventToCallbackMap), e = 0; e < t.length; e++) {
                            var n = t[e];
                            this.eventToCallbackMap[n] = null
                        }
                    },
                    _showTooltip: function() {
                        !1 === this.options.tooltip_split ? this._addClass(this.tooltip, "in") : (this._addClass(this.tooltip_min, "in"), this._addClass(this.tooltip_max, "in")), this.over = !0
                    },
                    _hideTooltip: function() {
                        !1 === this.inDrag && !0 !== this.alwaysShowTooltip && (this._removeClass(this.tooltip, "in"), this._removeClass(this.tooltip_min, "in"), this._removeClass(this.tooltip_max, "in")), this.over = !1
                    },
                    _layout: function() {
                        var t;
                        if (t = this.options.reversed ? [100 - this.percentage[0], this.percentage[1]] : [this.percentage[0], this.percentage[1]], this.handle1.style[this.stylePos] = t[0] + "%", this.handle2.style[this.stylePos] = t[1] + "%", Array.isArray(this.options.ticks) && this.options.ticks.length > 0) {
                            var e = Math.max.apply(Math, this.options.ticks),
                                n = Math.min.apply(Math, this.options.ticks),
                                i = "vertical" === this.options.orientation ? "height" : "width",
                                r = "vertical" === this.options.orientation ? "marginTop" : "marginLeft",
                                o = this.size / (this.options.ticks.length - 1);
                            if (this.tickLabelContainer) {
                                var s = 0;
                                if (0 === this.options.ticks_positions.length) this.tickLabelContainer.style[r] = -o / 2 + "px", s = this.tickLabelContainer.offsetHeight;
                                else
                                    for (a = 0; a < this.tickLabelContainer.childNodes.length; a++) this.tickLabelContainer.childNodes[a].offsetHeight > s && (s = this.tickLabelContainer.childNodes[a].offsetHeight);
                                "horizontal" === this.options.orientation && (this.sliderElem.style.marginBottom = s + "px")
                            }
                            for (var a = 0; a < this.options.ticks.length; a++) {
                                var l = this.options.ticks_positions[a] || 100 * (this.options.ticks[a] - n) / (e - n);
                                this.ticks[a].style[this.stylePos] = l + "%", this._removeClass(this.ticks[a], "in-selection"), this.options.range ? l >= t[0] && l <= t[1] && this._addClass(this.ticks[a], "in-selection") : "after" === this.options.selection && l >= t[0] ? this._addClass(this.ticks[a], "in-selection") : "before" === this.options.selection && l <= t[0] && this._addClass(this.ticks[a], "in-selection"), this.tickLabels[a] && (this.tickLabels[a].style[i] = o + "px", void 0 !== this.options.ticks_positions[a] && (this.tickLabels[a].style.position = "absolute", this.tickLabels[a].style[this.stylePos] = this.options.ticks_positions[a] + "%", this.tickLabels[a].style[r] = -o / 2 + "px"))
                            }
                        }
                        if ("vertical" === this.options.orientation) this.trackLow.style.top = "0", this.trackLow.style.height = Math.min(t[0], t[1]) + "%", this.trackSelection.style.top = Math.min(t[0], t[1]) + "%", this.trackSelection.style.height = Math.abs(t[0] - t[1]) + "%", this.trackHigh.style.bottom = "0", this.trackHigh.style.height = 100 - Math.min(t[0], t[1]) - Math.abs(t[0] - t[1]) + "%";
                        else {
                            this.trackLow.style.left = "0", this.trackLow.style.width = Math.min(t[0], t[1]) + "%", this.trackSelection.style.left = Math.min(t[0], t[1]) + "%", this.trackSelection.style.width = Math.abs(t[0] - t[1]) + "%", this.trackHigh.style.right = "0", this.trackHigh.style.width = 100 - Math.min(t[0], t[1]) - Math.abs(t[0] - t[1]) + "%";
                            var u = this.tooltip_min.getBoundingClientRect(),
                                c = this.tooltip_max.getBoundingClientRect();
                            u.right > c.left ? (this._removeClass(this.tooltip_max, "top"), this._addClass(this.tooltip_max, "bottom"), this.tooltip_max.style.top = "18px") : (this._removeClass(this.tooltip_max, "bottom"), this._addClass(this.tooltip_max, "top"), this.tooltip_max.style.top = this.tooltip_min.style.top)
                        }
                        var h;
                        if (this.options.range) {
                            h = this.options.formatter(this.options.value), this._setText(this.tooltipInner, h), this.tooltip.style[this.stylePos] = (t[1] + t[0]) / 2 + "%", "vertical" === this.options.orientation ? this._css(this.tooltip, "margin-top", -this.tooltip.offsetHeight / 2 + "px") : this._css(this.tooltip, "margin-left", -this.tooltip.offsetWidth / 2 + "px"), "vertical" === this.options.orientation ? this._css(this.tooltip, "margin-top", -this.tooltip.offsetHeight / 2 + "px") : this._css(this.tooltip, "margin-left", -this.tooltip.offsetWidth / 2 + "px");
                            var d = this.options.formatter(this.options.value[0]);
                            this._setText(this.tooltipInner_min, d);
                            var f = this.options.formatter(this.options.value[1]);
                            this._setText(this.tooltipInner_max, f), this.tooltip_min.style[this.stylePos] = t[0] + "%", "vertical" === this.options.orientation ? this._css(this.tooltip_min, "margin-top", -this.tooltip_min.offsetHeight / 2 + "px") : this._css(this.tooltip_min, "margin-left", -this.tooltip_min.offsetWidth / 2 + "px"), this.tooltip_max.style[this.stylePos] = t[1] + "%", "vertical" === this.options.orientation ? this._css(this.tooltip_max, "margin-top", -this.tooltip_max.offsetHeight / 2 + "px") : this._css(this.tooltip_max, "margin-left", -this.tooltip_max.offsetWidth / 2 + "px")
                        } else h = this.options.formatter(this.options.value[0]), this._setText(this.tooltipInner, h), this.tooltip.style[this.stylePos] = t[0] + "%", "vertical" === this.options.orientation ? this._css(this.tooltip, "margin-top", -this.tooltip.offsetHeight / 2 + "px") : this._css(this.tooltip, "margin-left", -this.tooltip.offsetWidth / 2 + "px")
                    },
                    _removeProperty: function(t, e) {
                        t.style.removeProperty ? t.style.removeProperty(e) : t.style.removeAttribute(e)
                    },
                    _mousedown: function(t) {
                        if (!this.options.enabled) return !1;
                        this.offset = this._offset(this.sliderElem), this.size = this.sliderElem[this.sizePos];
                        var e = this._getPercentage(t);
                        if (this.options.range) {
                            var n = Math.abs(this.percentage[0] - e),
                                i = Math.abs(this.percentage[1] - e);
                            this.dragged = i > n ? 0 : 1
                        } else this.dragged = 0;
                        this.percentage[this.dragged] = this.options.reversed ? 100 - e : e, this._layout(), this.touchCapable && (document.removeEventListener("touchmove", this.mousemove, !1), document.removeEventListener("touchend", this.mouseup, !1)), this.mousemove && document.removeEventListener("mousemove", this.mousemove, !1), this.mouseup && document.removeEventListener("mouseup", this.mouseup, !1), this.mousemove = this._mousemove.bind(this), this.mouseup = this._mouseup.bind(this), this.touchCapable && (document.addEventListener("touchmove", this.mousemove, !1), document.addEventListener("touchend", this.mouseup, !1)), document.addEventListener("mousemove", this.mousemove, !1), document.addEventListener("mouseup", this.mouseup, !1), this.inDrag = !0;
                        var r = this._calculateValue();
                        return this._trigger("slideStart", r), this._setDataVal(r), this.setValue(r, !1, !0), this._pauseEvent(t), this.options.focus && this._triggerFocusOnHandle(this.dragged), !0
                    },
                    _triggerFocusOnHandle: function(t) {
                        0 === t && this.handle1.focus(), 1 === t && this.handle2.focus()
                    },
                    _keydown: function(t, e) {
                        if (!this.options.enabled) return !1;
                        var n;
                        switch (e.keyCode) {
                            case 37:
                            case 40:
                                n = -1;
                                break;
                            case 39:
                            case 38:
                                n = 1
                        }
                        if (n) {
                            if (this.options.natural_arrow_keys) {
                                var i = "vertical" === this.options.orientation && !this.options.reversed,
                                    r = "horizontal" === this.options.orientation && this.options.reversed;
                                (i || r) && (n = -n)
                            }
                            var o = this.options.value[t] + n * this.options.step;
                            return this.options.range && (o = [t ? this.options.value[0] : o, t ? o : this.options.value[1]]), this._trigger("slideStart", o), this._setDataVal(o), this.setValue(o, !0, !0), this._trigger("slideStop", o), this._setDataVal(o), this._layout(), this._pauseEvent(e), !1
                        }
                    },
                    _pauseEvent: function(t) {
                        t.stopPropagation && t.stopPropagation(), t.preventDefault && t.preventDefault(), t.cancelBubble = !0, t.returnValue = !1
                    },
                    _mousemove: function(t) {
                        if (!this.options.enabled) return !1;
                        var e = this._getPercentage(t);
                        this._adjustPercentageForRangeSliders(e), this.percentage[this.dragged] = this.options.reversed ? 100 - e : e, this._layout();
                        var n = this._calculateValue(!0);
                        return this.setValue(n, !0, !0), !1
                    },
                    _adjustPercentageForRangeSliders: function(t) {
                        this.options.range && (0 === this.dragged && this.percentage[1] < t ? (this.percentage[0] = this.percentage[1], this.dragged = 1) : 1 === this.dragged && this.percentage[0] > t && (this.percentage[1] = this.percentage[0], this.dragged = 0))
                    },
                    _mouseup: function() {
                        if (!this.options.enabled) return !1;
                        this.touchCapable && (document.removeEventListener("touchmove", this.mousemove, !1), document.removeEventListener("touchend", this.mouseup, !1)), document.removeEventListener("mousemove", this.mousemove, !1), document.removeEventListener("mouseup", this.mouseup, !1), this.inDrag = !1, !1 === this.over && this._hideTooltip();
                        var t = this._calculateValue(!0);
                        return this._layout(), this._trigger("slideStop", t), this._setDataVal(t), !1
                    },
                    _calculateValue: function(t) {
                        var e;
                        if (this.options.range ? (e = [this.options.min, this.options.max], 0 !== this.percentage[0] && (e[0] = this._toValue(this.percentage[0]), e[0] = this._applyPrecision(e[0])), 100 !== this.percentage[1] && (e[1] = this._toValue(this.percentage[1]), e[1] = this._applyPrecision(e[1]))) : (e = this._toValue(this.percentage[0]), e = parseFloat(e), e = this._applyPrecision(e)), t) {
                            for (var n = [e, 1 / 0], i = 0; i < this.options.ticks.length; i++) {
                                var r = Math.abs(this.options.ticks[i] - e);
                                r <= n[1] && (n = [this.options.ticks[i], r])
                            }
                            if (n[1] <= this.options.ticks_snap_bounds) return n[0]
                        }
                        return e
                    },
                    _applyPrecision: function(t) {
                        var e = this.options.precision || this._getNumDigitsAfterDecimalPlace(this.options.step);
                        return this._applyToFixedAndParseFloat(t, e)
                    },
                    _getNumDigitsAfterDecimalPlace: function(t) {
                        var e = ("" + t).match(/(?:\.(\d+))?(?:[eE]([+-]?\d+))?$/);
                        return e ? Math.max(0, (e[1] ? e[1].length : 0) - (e[2] ? +e[2] : 0)) : 0
                    },
                    _applyToFixedAndParseFloat: function(t, e) {
                        var n = t.toFixed(e);
                        return parseFloat(n)
                    },
                    _getPercentage: function(t) {
                        !this.touchCapable || "touchstart" !== t.type && "touchmove" !== t.type || (t = t.touches[0]);
                        var e = t[this.mousePos],
                            n = this.offset[this.stylePos],
                            i = e - n,
                            r = i / this.size * 100;
                        return r = Math.round(r / this.percentage[2]) * this.percentage[2], Math.max(0, Math.min(100, r))
                    },
                    _validateInputValue: function(t) {
                        if ("number" == typeof t) return t;
                        if (Array.isArray(t)) return this._validateArray(t), t;
                        throw new Error(i.formatInvalidInputErrorMsg(t))
                    },
                    _validateArray: function(t) {
                        for (var e = 0; e < t.length; e++) {
                            var n = t[e];
                            if ("number" != typeof n) throw new Error(i.formatInvalidInputErrorMsg(n))
                        }
                    },
                    _setDataVal: function(t) {
                        var e = "value: '" + t + "'";
                        this.element.setAttribute("data", e), this.element.setAttribute("value", t), this.element.value = t
                    },
                    _trigger: function(e, n) {
                        n = n || 0 === n ? n : void 0;
                        var i = this.eventToCallbackMap[e];
                        if (i && i.length)
                            for (var r = 0; r < i.length; r++) {
                                var o = i[r];
                                o(n)
                            }
                        t && this._triggerJQueryEvent(e, n)
                    },
                    _triggerJQueryEvent: function(t, e) {
                        var n = {
                            type: t,
                            value: e
                        };
                        this.$element.trigger(n), this.$sliderElem.trigger(n)
                    },
                    _unbindJQueryEventHandlers: function() {
                        this.$element.off(), this.$sliderElem.off()
                    },
                    _setText: function(t, e) {
                        void 0 !== t.innerText ? t.innerText = e : void 0 !== t.textContent && (t.textContent = e)
                    },
                    _removeClass: function(t, e) {
                        for (var n = e.split(" "), i = t.className, r = 0; r < n.length; r++) {
                            var o = n[r],
                                s = new RegExp("(?:\\s|^)" + o + "(?:\\s|$)");
                            i = i.replace(s, " ")
                        }
                        t.className = i.trim()
                    },
                    _addClass: function(t, e) {
                        for (var n = e.split(" "), i = t.className, r = 0; r < n.length; r++) {
                            var o = n[r];
                            new RegExp("(?:\\s|^)" + o + "(?:\\s|$)").test(i) || (i += " " + o)
                        }
                        t.className = i.trim()
                    },
                    _offsetLeft: function(t) {
                        for (var e = t.offsetLeft;
                            (t = t.offsetParent) && !isNaN(t.offsetLeft);) e += t.offsetLeft;
                        return e
                    },
                    _offsetTop: function(t) {
                        for (var e = t.offsetTop;
                            (t = t.offsetParent) && !isNaN(t.offsetTop);) e += t.offsetTop;
                        return e
                    },
                    _offset: function(t) {
                        return {
                            left: this._offsetLeft(t),
                            top: this._offsetTop(t)
                        }
                    },
                    _css: function(e, n, i) {
                        if (t) t.style(e, n, i);
                        else {
                            var r = n.replace(/^-ms-/, "ms-").replace(/-([\da-z])/gi, function(t, e) {
                                return e.toUpperCase()
                            });
                            e.style[r] = i
                        }
                    },
                    _toValue: function(t) {
                        return this.options.scale.toValue.apply(this, [t])
                    },
                    _toPercentage: function(t) {
                        return this.options.scale.toPercentage.apply(this, [t])
                    }
                }, t) {
                var o = t.fn.slider ? "bootstrapSlider" : "slider";
                t.bridget(o, e)
            }
        }(t), e
}),
function(t) {
    "use strict";

    function e(e) {
        var i = arguments[1];
        return this.each(function() {
            var r = t(this),
                o = r.data("bs.toggle"),
                s = "object" == typeof e && e;
            o || r.data("bs.toggle", o = new n(this, s)), "string" == typeof e && o[e] && o[e](i)
        })
    }
    var n = function(e, n) {
        this.$element = t(e), this.options = t.extend({}, this.defaults(), n), this.render()
    };
    n.VERSION = "2.2.0", n.DEFAULTS = {
        on: "On",
        off: "Off",
        onstyle: "primary",
        offstyle: "default",
        size: "normal",
        style: "",
        width: null,
        height: null
    }, n.prototype.defaults = function() {
        return {
            on: this.$element.attr("data-on") || n.DEFAULTS.on,
            off: this.$element.attr("data-off") || n.DEFAULTS.off,
            onstyle: this.$element.attr("data-onstyle") || n.DEFAULTS.onstyle,
            offstyle: this.$element.attr("data-offstyle") || n.DEFAULTS.offstyle,
            size: this.$element.attr("data-size") || n.DEFAULTS.size,
            style: this.$element.attr("data-style") || n.DEFAULTS.style,
            width: this.$element.attr("data-width") || n.DEFAULTS.width,
            height: this.$element.attr("data-height") || n.DEFAULTS.height
        }
    }, n.prototype.render = function() {
        this._onstyle = "btn-" + this.options.onstyle, this._offstyle = "btn-" + this.options.offstyle;
        var e = "large" === this.options.size ? "btn-lg" : "small" === this.options.size ? "btn-sm" : "mini" === this.options.size ? "btn-xs" : "",
            n = t('<label class="btn">').html(this.options.on).addClass(this._onstyle + " " + e),
            i = t('<label class="btn">').html(this.options.off).addClass(this._offstyle + " " + e + " active"),
            r = t('<span class="toggle-handle btn btn-default">').addClass(e),
            o = t('<div class="toggle-group">').append(n, i, r),
            s = t('<div class="toggle btn" data-toggle="toggle">').addClass(this.$element.prop("checked") ? this._onstyle : this._offstyle + " off").addClass(e).addClass(this.options.style);
        this.$element.wrap(s), t.extend(this, {
            $toggle: this.$element.parent(),
            $toggleOn: n,
            $toggleOff: i,
            $toggleGroup: o
        }), this.$toggle.append(o);
        var a = this.options.width || Math.max(n.outerWidth(), i.outerWidth()) + r.outerWidth() / 2,
            l = this.options.height || Math.max(n.outerHeight(), i.outerHeight());
        n.addClass("toggle-on"), i.addClass("toggle-off"), this.$toggle.css({
            width: a,
            height: l
        }), this.options.height && (n.css("line-height", n.height() + "px"), i.css("line-height", i.height() + "px")), this.update(!0), this.trigger(!0)
    }, n.prototype.toggle = function() {
        this.$element.prop("checked") ? this.off() : this.on()
    }, n.prototype.on = function(t) {
        if (this.$element.prop("disabled")) return !1;
        this.$toggle.removeClass(this._offstyle + " off").addClass(this._onstyle), this.$element.prop("checked", !0), t || this.trigger()
    }, n.prototype.off = function(t) {
        if (this.$element.prop("disabled")) return !1;
        this.$toggle.removeClass(this._onstyle).addClass(this._offstyle + " off"), this.$element.prop("checked", !1), t || this.trigger()
    }, n.prototype.enable = function() {
        this.$toggle.removeAttr("disabled"), this.$element.prop("disabled", !1)
    }, n.prototype.disable = function() {
        this.$toggle.attr("disabled", "disabled"), this.$element.prop("disabled", !0)
    }, n.prototype.update = function(t) {
        this.$element.prop("disabled") ? this.disable() : this.enable(), this.$element.prop("checked") ? this.on(t) : this.off(t)
    }, n.prototype.trigger = function(e) {
        this.$element.off("change.bs.toggle"), e || this.$element.change(), this.$element.on("change.bs.toggle", t.proxy(function() {
            this.update()
        }, this))
    }, n.prototype.destroy = function() {
        this.$element.off("change.bs.toggle"), this.$toggleGroup.remove(), this.$element.removeData("bs.toggle"),
            this.$element.unwrap()
    };
    var i = t.fn.bootstrapToggle;
    t.fn.bootstrapToggle = e, t.fn.bootstrapToggle.Constructor = n, t.fn.toggle.noConflict = function() {
        return t.fn.bootstrapToggle = i, this
    }, t(function() {
        t("input[type=checkbox][data-toggle^=toggle]").bootstrapToggle()
    }), t(document).on("click.bs.toggle", "div[data-toggle^=toggle]", function(e) {
        t(this).find("input[type=checkbox]").bootstrapToggle("toggle"), e.preventDefault()
    })
}(jQuery),
function(t) {
    "use strict";

    function e(t, e) {
        return t + ".touchspin_" + e
    }

    function n(n, i) {
        return t.map(n, function(t) {
            return e(t, i)
        })
    }
    var i = 0;
    t.fn.TouchSpin = function(e) {
        if ("destroy" === e) return void this.each(function() {
            var e = t(this),
                i = e.data();
            t(document).off(n(["mouseup", "touchend", "touchcancel", "mousemove", "touchmove", "scroll", "scrollstart"], i.spinnerid).join(" "))
        });
        var r = {
                min: 0,
                max: 100,
                initval: "",
                step: 1,
                decimals: 0,
                stepinterval: 100,
                forcestepdivisibility: "round",
                stepintervaldelay: 500,
                verticalbuttons: !1,
                verticalupclass: "glyphicon glyphicon-chevron-up",
                verticaldownclass: "glyphicon glyphicon-chevron-down",
                prefix: "",
                postfix: "",
                prefix_extraclass: "",
                postfix_extraclass: "",
                booster: !0,
                boostat: 10,
                maxboostedstep: !1,
                mousewheel: !0,
                buttondown_class: "btn btn-default",
                buttonup_class: "btn btn-default",
                buttondown_txt: "-",
                buttonup_txt: "+"
            },
            o = {
                min: "min",
                max: "max",
                initval: "init-val",
                step: "step",
                decimals: "decimals",
                stepinterval: "step-interval",
                verticalbuttons: "vertical-buttons",
                verticalupclass: "vertical-up-class",
                verticaldownclass: "vertical-down-class",
                forcestepdivisibility: "force-step-divisibility",
                stepintervaldelay: "step-interval-delay",
                prefix: "prefix",
                postfix: "postfix",
                prefix_extraclass: "prefix-extra-class",
                postfix_extraclass: "postfix-extra-class",
                booster: "booster",
                boostat: "boostat",
                maxboostedstep: "max-boosted-step",
                mousewheel: "mouse-wheel",
                buttondown_class: "button-down-class",
                buttonup_class: "button-up-class",
                buttondown_txt: "button-down-txt",
                buttonup_txt: "button-up-txt"
            };
        return this.each(function() {
            function s() {
                "" !== T.initval && "" === L.val() && L.val(T.initval)
            }

            function a(t) {
                c(t), b();
                var e = A.input.val();
                "" !== e && (e = Number(A.input.val()), A.input.val(e.toFixed(T.decimals)))
            }

            function l() {
                T = t.extend({}, r, $, u(), e)
            }

            function u() {
                var e = {};
                return t.each(o, function(t, n) {
                    var i = "bts-" + n;
                    L.is("[data-" + i + "]") && (e[t] = L.data(i))
                }), e
            }

            function c(e) {
                T = t.extend({}, T, e)
            }

            function h() {
                var t = L.val(),
                    e = L.parent();
                "" !== t && (t = Number(t).toFixed(T.decimals)), L.data("initvalue", t).val(t), L.addClass("form-control"), e.hasClass("input-group") ? d(e) : f()
            }

            function d(e) {
                e.addClass("bootstrap-touchspin");
                var n, i, r = L.prev(),
                    o = L.next(),
                    s = '<span class="input-group-addon bootstrap-touchspin-prefix">' + T.prefix + "</span>",
                    a = '<span class="input-group-addon bootstrap-touchspin-postfix">' + T.postfix + "</span>";
                r.hasClass("input-group-btn") ? (n = '<button class="' + T.buttondown_class + ' bootstrap-touchspin-down" type="button">' + T.buttondown_txt + "</button>", r.append(n)) : (n = '<span class="input-group-btn"><button class="' + T.buttondown_class + ' bootstrap-touchspin-down" type="button">' + T.buttondown_txt + "</button></span>", t(n).insertBefore(L)), o.hasClass("input-group-btn") ? (i = '<button class="' + T.buttonup_class + ' bootstrap-touchspin-up" type="button">' + T.buttonup_txt + "</button>", o.prepend(i)) : (i = '<span class="input-group-btn"><button class="' + T.buttonup_class + ' bootstrap-touchspin-up" type="button">' + T.buttonup_txt + "</button></span>", t(i).insertAfter(L)), t(s).insertBefore(L), t(a).insertAfter(L), S = e
            }

            function f() {
                var e;
                e = T.verticalbuttons ? '<div class="input-group bootstrap-touchspin"><span class="input-group-addon bootstrap-touchspin-prefix">' + T.prefix + '</span><span class="input-group-addon bootstrap-touchspin-postfix">' + T.postfix + '</span><span class="input-group-btn-vertical"><button class="' + T.buttondown_class + ' bootstrap-touchspin-up" type="button"><i class="' + T.verticalupclass + '"></i></button><button class="' + T.buttonup_class + ' bootstrap-touchspin-down" type="button"><i class="' + T.verticaldownclass + '"></i></button></span></div>' : '<div class="input-group bootstrap-touchspin"><span class="input-group-btn"><button class="' + T.buttondown_class + ' bootstrap-touchspin-down" type="button">' + T.buttondown_txt + '</button></span><span class="input-group-addon bootstrap-touchspin-prefix">' + T.prefix + '</span><span class="input-group-addon bootstrap-touchspin-postfix">' + T.postfix + '</span><span class="input-group-btn"><button class="' + T.buttonup_class + ' bootstrap-touchspin-up" type="button">' + T.buttonup_txt + "</button></span></div>", S = t(e).insertBefore(L), t(".bootstrap-touchspin-prefix", S).after(L), L.hasClass("input-sm") ? S.addClass("input-group-sm") : L.hasClass("input-lg") && S.addClass("input-group-lg")
            }

            function p() {
                A = {
                    down: t(".bootstrap-touchspin-down", S),
                    up: t(".bootstrap-touchspin-up", S),
                    input: t("input", S),
                    prefix: t(".bootstrap-touchspin-prefix", S).addClass(T.prefix_extraclass),
                    postfix: t(".bootstrap-touchspin-postfix", S).addClass(T.postfix_extraclass)
                }
            }

            function m() {
                "" === T.prefix && A.prefix.hide(), "" === T.postfix && A.postfix.hide()
            }

            function g() {
                L.on("keydown", function(t) {
                    var e = t.keyCode || t.which;
                    38 === e ? ("up" !== P && (w(), C()), t.preventDefault()) : 40 === e && ("down" !== P && (x(), k()), t.preventDefault())
                }), L.on("keyup", function(t) {
                    var e = t.keyCode || t.which;
                    38 === e ? E() : 40 === e && E()
                }), L.on("blur", function() {
                    b()
                }), A.down.on("keydown", function(t) {
                    var e = t.keyCode || t.which;
                    (32 === e || 13 === e) && ("down" !== P && (x(), k()), t.preventDefault())
                }), A.down.on("keyup", function(t) {
                    var e = t.keyCode || t.which;
                    (32 === e || 13 === e) && E()
                }), A.up.on("keydown", function(t) {
                    var e = t.keyCode || t.which;
                    (32 === e || 13 === e) && ("up" !== P && (w(), C()), t.preventDefault())
                }), A.up.on("keyup", function(t) {
                    var e = t.keyCode || t.which;
                    (32 === e || 13 === e) && E()
                }), A.down.on("mousedown.touchspin", function(t) {
                    A.down.off("touchstart.touchspin"), L.is(":disabled") || (x(), k(), t.preventDefault(), t.stopPropagation())
                }), A.down.on("touchstart.touchspin", function(t) {
                    A.down.off("mousedown.touchspin"), L.is(":disabled") || (x(), k(), t.preventDefault(), t.stopPropagation())
                }), A.up.on("mousedown.touchspin", function(t) {
                    A.up.off("touchstart.touchspin"), L.is(":disabled") || (w(), C(), t.preventDefault(), t.stopPropagation())
                }), A.up.on("touchstart.touchspin", function(t) {
                    A.up.off("mousedown.touchspin"), L.is(":disabled") || (w(), C(), t.preventDefault(), t.stopPropagation())
                }), A.up.on("mouseout touchleave touchend touchcancel", function(t) {
                    P && (t.stopPropagation(), E())
                }), A.down.on("mouseout touchleave touchend touchcancel", function(t) {
                    P && (t.stopPropagation(), E())
                }), A.down.on("mousemove touchmove", function(t) {
                    P && (t.stopPropagation(), t.preventDefault())
                }), A.up.on("mousemove touchmove", function(t) {
                    P && (t.stopPropagation(), t.preventDefault())
                }), t(document).on(n(["mouseup", "touchend", "touchcancel"], i).join(" "), function(t) {
                    P && (t.preventDefault(), E())
                }), t(document).on(n(["mousemove", "touchmove", "scroll", "scrollstart"], i).join(" "), function(t) {
                    P && (t.preventDefault(), E())
                }), L.on("mousewheel DOMMouseScroll", function(t) {
                    if (T.mousewheel && L.is(":focus")) {
                        var e = t.originalEvent.wheelDelta || -t.originalEvent.deltaY || -t.originalEvent.detail;
                        t.stopPropagation(), t.preventDefault(), 0 > e ? x() : w()
                    }
                })
            }

            function v() {
                L.on("touchspin.uponce", function() {
                    E(), w()
                }), L.on("touchspin.downonce", function() {
                    E(), x()
                }), L.on("touchspin.startupspin", function() {
                    C()
                }), L.on("touchspin.startdownspin", function() {
                    k()
                }), L.on("touchspin.stopspin", function() {
                    E()
                }), L.on("touchspin.updatesettings", function(t, e) {
                    a(e)
                })
            }

            function y(t) {
                switch (T.forcestepdivisibility) {
                    case "round":
                        return (Math.round(t / T.step) * T.step).toFixed(T.decimals);
                    case "floor":
                        return (Math.floor(t / T.step) * T.step).toFixed(T.decimals);
                    case "ceil":
                        return (Math.ceil(t / T.step) * T.step).toFixed(T.decimals);
                    default:
                        return t
                }
            }

            function b() {
                var t, e, n;
                "" !== (t = L.val()) && (T.decimals > 0 && "." === t || (e = parseFloat(t), isNaN(e) && (e = 0), n = e, e.toString() !== t && (n = e), e < T.min && (n = T.min), e > T.max && (n = T.max), n = y(n), Number(t).toString() !== n.toString() && (L.val(n), L.trigger("change"))))
            }

            function _() {
                if (T.booster) {
                    var t = Math.pow(2, Math.floor(R / T.boostat)) * T.step;
                    return T.maxboostedstep && t > T.maxboostedstep && (t = T.maxboostedstep, N = Math.round(N / t) * t), Math.max(T.step, t)
                }
                return T.step
            }

            function w() {
                b(), N = parseFloat(A.input.val()), isNaN(N) && (N = 0);
                var t = N,
                    e = _();
                N += e, N > T.max && (N = T.max, L.trigger("touchspin.on.max"), E()), A.input.val(Number(N).toFixed(T.decimals)), t !== N && L.trigger("change")
            }

            function x() {
                b(), N = parseFloat(A.input.val()), isNaN(N) && (N = 0);
                var t = N,
                    e = _();
                N -= e, N < T.min && (N = T.min, L.trigger("touchspin.on.min"), E()), A.input.val(N.toFixed(T.decimals)), t !== N && L.trigger("change")
            }

            function k() {
                E(), R = 0, P = "down", L.trigger("touchspin.on.startspin"), L.trigger("touchspin.on.startdownspin"), I = setTimeout(function() {
                    D = setInterval(function() {
                        R++, x()
                    }, T.stepinterval)
                }, T.stepintervaldelay)
            }

            function C() {
                E(), R = 0, P = "up", L.trigger("touchspin.on.startspin"), L.trigger("touchspin.on.startupspin"), z = setTimeout(function() {
                    O = setInterval(function() {
                        R++, w()
                    }, T.stepinterval)
                }, T.stepintervaldelay)
            }

            function E() {
                switch (clearTimeout(I), clearTimeout(z), clearInterval(D), clearInterval(O), P) {
                    case "up":
                        L.trigger("touchspin.on.stopupspin"), L.trigger("touchspin.on.stopspin");
                        break;
                    case "down":
                        L.trigger("touchspin.on.stopdownspin"), L.trigger("touchspin.on.stopspin")
                }
                R = 0, P = !1
            }
            var T, S, A, N, D, O, I, z, L = t(this),
                $ = L.data(),
                R = 0,
                P = !1;
            ! function() {
                if (!L.data("alreadyinitialized")) {
                    if (L.data("alreadyinitialized", !0), i += 1, L.data("spinnerid", i), !L.is("input")) return void console.log("Must be an input.");
                    l(), s(), b(), h(), p(), m(), g(), v(), A.input.css("display", "block")
                }
            }()
        })
    }
}(jQuery),
function(t) {
    if ("object" == typeof exports && "undefined" != typeof module) module.exports = t();
    else if ("function" == typeof define && define.amd) define([], t);
    else {
        var e;
        "undefined" != typeof window ? e = window : "undefined" != typeof global ? e = global : "undefined" != typeof self && (e = self), e.ProgressBar = t()
    }
}(function() {
    var t;
    return function t(e, n, i) {
        function r(s, a) {
            if (!n[s]) {
                if (!e[s]) {
                    var l = "function" == typeof require && require;
                    if (!a && l) return l(s, !0);
                    if (o) return o(s, !0);
                    var u = new Error("Cannot find module '" + s + "'");
                    throw u.code = "MODULE_NOT_FOUND", u
                }
                var c = n[s] = {
                    exports: {}
                };
                e[s][0].call(c.exports, function(t) {
                    var n = e[s][1][t];
                    return r(n || t)
                }, c, c.exports, t, e, n, i)
            }
            return n[s].exports
        }
        for (var o = "function" == typeof require && require, s = 0; s < i.length; s++) r(i[s]);
        return r
    }({
        1: [function(e, n, i) {
            ! function(e) {
                "undefined" == typeof SHIFTY_DEBUG_NOW && (SHIFTY_DEBUG_NOW = function() {
                    return +new Date
                });
                var r = function() {
                    "use strict";

                    function r() {}

                    function o(t, e) {
                        var n;
                        for (n in t) Object.hasOwnProperty.call(t, n) && e(n)
                    }

                    function s(t, e) {
                        return o(e, function(n) {
                            t[n] = e[n]
                        }), t
                    }

                    function a(t, e) {
                        o(e, function(n) {
                            void 0 === t[n] && (t[n] = e[n])
                        })
                    }

                    function l(t, e, n, i, r, o, s) {
                        var a, l = (t - o) / r;
                        for (a in e) e.hasOwnProperty(a) && (e[a] = u(n[a], i[a], p[s[a]], l));
                        return e
                    }

                    function u(t, e, n, i) {
                        return t + (e - t) * n(i)
                    }

                    function c(t, e) {
                        var n = f.prototype.filter,
                            i = t._filterArgs;
                        o(n, function(r) {
                            void 0 !== n[r][e] && n[r][e].apply(t, i)
                        })
                    }

                    function h(t, e, n, i, r, o, s, a, u) {
                        _ = e + n, w = Math.min(b(), _), x = w >= _, t.isPlaying() && !x ? (u(t._timeoutHandler, v), c(t, "beforeTween"), l(w, i, r, o, n, e, s), c(t, "afterTween"), a(i)) : x && (a(o), t.stop(!0))
                    }

                    function d(t, e) {
                        var n = {};
                        return "string" == typeof e ? o(t, function(t) {
                            n[t] = e
                        }) : o(t, function(t) {
                            n[t] || (n[t] = e[t] || g)
                        }), n
                    }

                    function f(t, e) {
                        this._currentState = t || {}, this._configured = !1, this._scheduleFunction = m, void 0 !== e && this.setConfig(e)
                    }
                    var p, m, g = "linear",
                        v = 1e3 / 60,
                        y = Date.now ? Date.now : function() {
                            return +new Date
                        },
                        b = SHIFTY_DEBUG_NOW || y;
                    m = "undefined" != typeof window ? window.requestAnimationFrame || window.webkitRequestAnimationFrame || window.oRequestAnimationFrame || window.msRequestAnimationFrame || window.mozCancelRequestAnimationFrame && window.mozRequestAnimationFrame || setTimeout : setTimeout;
                    var _, w, x;
                    return f.prototype.tween = function(t) {
                        return this._isTweening ? this : (void 0 === t && this._configured || this.setConfig(t), this._start(this.get()), this.resume())
                    }, f.prototype.setConfig = function(t) {
                        t = t || {}, this._configured = !0, this._pausedAtTime = null, this._start = t.start || r, this._step = t.step || r, this._finish = t.finish || r, this._duration = t.duration || 500, this._currentState = t.from || this.get(), this._originalState = this.get(), this._targetState = t.to || this.get(), this._timestamp = b();
                        var e = this._currentState,
                            n = this._targetState;
                        return a(n, e), this._easing = d(e, t.easing || g), this._filterArgs = [e, this._originalState, n, this._easing], c(this, "tweenCreated"), this
                    }, f.prototype.get = function() {
                        return s({}, this._currentState)
                    }, f.prototype.set = function(t) {
                        this._currentState = t
                    }, f.prototype.pause = function() {
                        return this._pausedAtTime = b(), this._isPaused = !0, this
                    }, f.prototype.resume = function() {
                        this._isPaused && (this._timestamp += b() - this._pausedAtTime), this._isPaused = !1, this._isTweening = !0;
                        var t = this;
                        return this._timeoutHandler = function() {
                            h(t, t._timestamp, t._duration, t._currentState, t._originalState, t._targetState, t._easing, t._step, t._scheduleFunction)
                        }, this._timeoutHandler(), this
                    }, f.prototype.stop = function(t) {
                        return this._isTweening = !1, this._isPaused = !1, this._timeoutHandler = r, t && (s(this._currentState, this._targetState), c(this, "afterTweenEnd"), this._finish.call(this, this._currentState)), this
                    }, f.prototype.isPlaying = function() {
                        return this._isTweening && !this._isPaused
                    }, f.prototype.setScheduleFunction = function(t) {
                        this._scheduleFunction = t
                    }, f.prototype.dispose = function() {
                        var t;
                        for (t in this) this.hasOwnProperty(t) && delete this[t]
                    }, f.prototype.filter = {}, f.prototype.formula = {
                        linear: function(t) {
                            return t
                        }
                    }, p = f.prototype.formula, s(f, {
                        now: b,
                        each: o,
                        tweenProps: l,
                        tweenProp: u,
                        applyFilter: c,
                        shallowCopy: s,
                        defaults: a,
                        composeEasingObject: d
                    }), "function" == typeof SHIFTY_DEBUG_NOW && (e.timeoutHandler = h), "object" == typeof i ? n.exports = f : "function" == typeof t && t.amd ? t(function() {
                        return f
                    }) : void 0 === e.Tweenable && (e.Tweenable = f), f
                }();
                ! function() {
                    r.shallowCopy(r.prototype.formula, {
                        easeInQuad: function(t) {
                            return Math.pow(t, 2)
                        },
                        easeOutQuad: function(t) {
                            return -(Math.pow(t - 1, 2) - 1)
                        },
                        easeInOutQuad: function(t) {
                            return (t /= .5) < 1 ? .5 * Math.pow(t, 2) : -.5 * ((t -= 2) * t - 2)
                        },
                        easeInCubic: function(t) {
                            return Math.pow(t, 3)
                        },
                        easeOutCubic: function(t) {
                            return Math.pow(t - 1, 3) + 1
                        },
                        easeInOutCubic: function(t) {
                            return (t /= .5) < 1 ? .5 * Math.pow(t, 3) : .5 * (Math.pow(t - 2, 3) + 2)
                        },
                        easeInQuart: function(t) {
                            return Math.pow(t, 4)
                        },
                        easeOutQuart: function(t) {
                            return -(Math.pow(t - 1, 4) - 1)
                        },
                        easeInOutQuart: function(t) {
                            return (t /= .5) < 1 ? .5 * Math.pow(t, 4) : -.5 * ((t -= 2) * Math.pow(t, 3) - 2)
                        },
                        easeInQuint: function(t) {
                            return Math.pow(t, 5)
                        },
                        easeOutQuint: function(t) {
                            return Math.pow(t - 1, 5) + 1
                        },
                        easeInOutQuint: function(t) {
                            return (t /= .5) < 1 ? .5 * Math.pow(t, 5) : .5 * (Math.pow(t - 2, 5) + 2)
                        },
                        easeInSine: function(t) {
                            return 1 - Math.cos(t * (Math.PI / 2))
                        },
                        easeOutSine: function(t) {
                            return Math.sin(t * (Math.PI / 2))
                        },
                        easeInOutSine: function(t) {
                            return -.5 * (Math.cos(Math.PI * t) - 1)
                        },
                        easeInExpo: function(t) {
                            return 0 === t ? 0 : Math.pow(2, 10 * (t - 1))
                        },
                        easeOutExpo: function(t) {
                            return 1 === t ? 1 : 1 - Math.pow(2, -10 * t)
                        },
                        easeInOutExpo: function(t) {
                            return 0 === t ? 0 : 1 === t ? 1 : (t /= .5) < 1 ? .5 * Math.pow(2, 10 * (t - 1)) : .5 * (2 - Math.pow(2, -10 * --t))
                        },
                        easeInCirc: function(t) {
                            return -(Math.sqrt(1 - t * t) - 1)
                        },
                        easeOutCirc: function(t) {
                            return Math.sqrt(1 - Math.pow(t - 1, 2))
                        },
                        easeInOutCirc: function(t) {
                            return (t /= .5) < 1 ? -.5 * (Math.sqrt(1 - t * t) - 1) : .5 * (Math.sqrt(1 - (t -= 2) * t) + 1)
                        },
                        easeOutBounce: function(t) {
                            return 1 / 2.75 > t ? 7.5625 * t * t : 2 / 2.75 > t ? 7.5625 * (t -= 1.5 / 2.75) * t + .75 : 2.5 / 2.75 > t ? 7.5625 * (t -= 2.25 / 2.75) * t + .9375 : 7.5625 * (t -= 2.625 / 2.75) * t + .984375
                        },
                        easeInBack: function(t) {
                            var e = 1.70158;
                            return t * t * ((e + 1) * t - e)
                        },
                        easeOutBack: function(t) {
                            var e = 1.70158;
                            return (t -= 1) * t * ((e + 1) * t + e) + 1
                        },
                        easeInOutBack: function(t) {
                            var e = 1.70158;
                            return (t /= .5) < 1 ? .5 * t * t * ((1 + (e *= 1.525)) * t - e) : .5 * ((t -= 2) * t * ((1 + (e *= 1.525)) * t + e) + 2)
                        },
                        elastic: function(t) {
                            return -1 * Math.pow(4, -8 * t) * Math.sin(2 * (6 * t - 1) * Math.PI / 2) + 1
                        },
                        swingFromTo: function(t) {
                            var e = 1.70158;
                            return (t /= .5) < 1 ? .5 * t * t * ((1 + (e *= 1.525)) * t - e) : .5 * ((t -= 2) * t * ((1 + (e *= 1.525)) * t + e) + 2)
                        },
                        swingFrom: function(t) {
                            var e = 1.70158;
                            return t * t * ((e + 1) * t - e)
                        },
                        swingTo: function(t) {
                            var e = 1.70158;
                            return (t -= 1) * t * ((e + 1) * t + e) + 1
                        },
                        bounce: function(t) {
                            return 1 / 2.75 > t ? 7.5625 * t * t : 2 / 2.75 > t ? 7.5625 * (t -= 1.5 / 2.75) * t + .75 : 2.5 / 2.75 > t ? 7.5625 * (t -= 2.25 / 2.75) * t + .9375 : 7.5625 * (t -= 2.625 / 2.75) * t + .984375
                        },
                        bouncePast: function(t) {
                            return 1 / 2.75 > t ? 7.5625 * t * t : 2 / 2.75 > t ? 2 - (7.5625 * (t -= 1.5 / 2.75) * t + .75) : 2.5 / 2.75 > t ? 2 - (7.5625 * (t -= 2.25 / 2.75) * t + .9375) : 2 - (7.5625 * (t -= 2.625 / 2.75) * t + .984375)
                        },
                        easeFromTo: function(t) {
                            return (t /= .5) < 1 ? .5 * Math.pow(t, 4) : -.5 * ((t -= 2) * Math.pow(t, 3) - 2)
                        },
                        easeFrom: function(t) {
                            return Math.pow(t, 4)
                        },
                        easeTo: function(t) {
                            return Math.pow(t, .25)
                        }
                    })
                }(),
                function() {
                    function t(t, e, n, i, r, o) {
                        function s(t) {
                            return ((h * t + d) * t + f) * t
                        }

                        function a(t) {
                            return ((p * t + m) * t + g) * t
                        }

                        function l(t) {
                            return (3 * h * t + 2 * d) * t + f
                        }

                        function u(t) {
                            return t >= 0 ? t : 0 - t
                        }

                        function c(t, e) {
                            var n, i, r, o, a, c;
                            for (r = t, c = 0; 8 > c; c++) {
                                if (o = s(r) - t, u(o) < e) return r;
                                if (a = l(r), u(a) < 1e-6) break;
                                r -= o / a
                            }
                            if (n = 0, i = 1, r = t, n > r) return n;
                            if (r > i) return i;
                            for (; i > n;) {
                                if (o = s(r), u(o - t) < e) return r;
                                t > o ? n = r : i = r, r = .5 * (i - n) + n
                            }
                            return r
                        }
                        var h = 0,
                            d = 0,
                            f = 0,
                            p = 0,
                            m = 0,
                            g = 0;
                        return f = 3 * e, d = 3 * (i - e) - f, h = 1 - f - d, g = 3 * n, m = 3 * (r - n) - g, p = 1 - g - m,
                            function(t, e) {
                                return a(c(t, e))
                            }(t, function(t) {
                                return 1 / (200 * t)
                            }(o))
                    }

                    function e(e, n, i, r) {
                        return function(o) {
                            return t(o, e, n, i, r, 1)
                        }
                    }
                    r.setBezierFunction = function(t, n, i, o, s) {
                        var a = e(n, i, o, s);
                        return a.x1 = n, a.y1 = i, a.x2 = o, a.y2 = s, r.prototype.formula[t] = a
                    }, r.unsetBezierFunction = function(t) {
                        delete r.prototype.formula[t]
                    }
                }(),
                function() {
                    function t(t, e, n, i, o) {
                        return r.tweenProps(i, e, t, n, 1, 0, o)
                    }
                    var e = new r;
                    e._filterArgs = [], r.interpolate = function(n, i, o, s) {
                        var a = r.shallowCopy({}, n),
                            l = r.composeEasingObject(n, s || "linear");
                        e.set({});
                        var u = e._filterArgs;
                        u.length = 0, u[0] = a, u[1] = n, u[2] = i, u[3] = l, r.applyFilter(e, "tweenCreated"), r.applyFilter(e, "beforeTween");
                        var c = t(n, a, i, o, l);
                        return r.applyFilter(e, "afterTween"), c
                    }
                }(),
                function(t) {
                    function e(t, e) {
                        S.length = 0;
                        var n, i = t.length;
                        for (n = 0; i > n; n++) S.push("_" + e + "_" + n);
                        return S
                    }

                    function n(t) {
                        var e = t.match(w);
                        return e ? (1 === e.length || t[0].match(_)) && e.unshift("") : e = ["", ""], e.join(T)
                    }

                    function i(e) {
                        t.each(e, function(t) {
                            var n = e[t];
                            "string" == typeof n && n.match(E) && (e[t] = r(n))
                        })
                    }

                    function r(t) {
                        return l(E, t, o)
                    }

                    function o(t) {
                        var e = s(t);
                        return "rgb(" + e[0] + "," + e[1] + "," + e[2] + ")"
                    }

                    function s(t) {
                        return t = t.replace(/#/, ""), 3 === t.length && (t = t.split(""), t = t[0] + t[0] + t[1] + t[1] + t[2] + t[2]), A[0] = a(t.substr(0, 2)), A[1] = a(t.substr(2, 2)), A[2] = a(t.substr(4, 2)), A
                    }

                    function a(t) {
                        return parseInt(t, 16)
                    }

                    function l(t, e, n) {
                        var i = e.match(t),
                            r = e.replace(t, T);
                        if (i)
                            for (var o, s = i.length, a = 0; s > a; a++) o = i.shift(), r = r.replace(T, n(o));
                        return r
                    }

                    function u(t) {
                        return l(k, t, c)
                    }

                    function c(t) {
                        for (var e = t.match(x), n = e.length, i = t.match(C)[0], r = 0; n > r; r++) i += parseInt(e[r], 10) + ",";
                        return i = i.slice(0, -1) + ")"
                    }

                    function h(i) {
                        var r = {};
                        return t.each(i, function(t) {
                            var o = i[t];
                            if ("string" == typeof o) {
                                var s = v(o);
                                r[t] = {
                                    formatString: n(o),
                                    chunkNames: e(s, t)
                                }
                            }
                        }), r
                    }

                    function d(e, n) {
                        t.each(n, function(t) {
                            for (var i = e[t], r = v(i), o = r.length, s = 0; o > s; s++) e[n[t].chunkNames[s]] = +r[s];
                            delete e[t]
                        })
                    }

                    function f(e, n) {
                        t.each(n, function(t) {
                            var i = e[t],
                                r = p(e, n[t].chunkNames),
                                o = m(r, n[t].chunkNames);
                            i = g(n[t].formatString, o), e[t] = u(i)
                        })
                    }

                    function p(t, e) {
                        for (var n, i = {}, r = e.length, o = 0; r > o; o++) n = e[o], i[n] = t[n], delete t[n];
                        return i
                    }

                    function m(t, e) {
                        N.length = 0;
                        for (var n = e.length, i = 0; n > i; i++) N.push(t[e[i]]);
                        return N
                    }

                    function g(t, e) {
                        for (var n = t, i = e.length, r = 0; i > r; r++) n = n.replace(T, +e[r].toFixed(4));
                        return n
                    }

                    function v(t) {
                        return t.match(x)
                    }

                    function y(e, n) {
                        t.each(n, function(t) {
                            for (var i = n[t], r = i.chunkNames, o = r.length, s = e[t].split(" "), a = s[s.length - 1], l = 0; o > l; l++) e[r[l]] = s[l] || a;
                            delete e[t]
                        })
                    }

                    function b(e, n) {
                        t.each(n, function(t) {
                            for (var i = n[t], r = i.chunkNames, o = r.length, s = "", a = 0; o > a; a++) s += " " + e[r[a]], delete e[r[a]];
                            e[t] = s.substr(1)
                        })
                    }
                    var _ = /(\d|\-|\.)/,
                        w = /([^\-0-9\.]+)/g,
                        x = /[0-9.\-]+/g,
                        k = new RegExp("rgb\\(" + x.source + /,\s*/.source + x.source + /,\s*/.source + x.source + "\\)", "g"),
                        C = /^.*\(/,
                        E = /#([0-9]|[a-f]){3,6}/gi,
                        T = "VAL",
                        S = [],
                        A = [],
                        N = [];
                    t.prototype.filter.token = {
                        tweenCreated: function(t, e, n) {
                            i(t), i(e), i(n), this._tokenData = h(t)
                        },
                        beforeTween: function(t, e, n, i) {
                            y(i, this._tokenData), d(t, this._tokenData), d(e, this._tokenData), d(n, this._tokenData)
                        },
                        afterTween: function(t, e, n, i) {
                            f(t, this._tokenData), f(e, this._tokenData), f(n, this._tokenData), b(i, this._tokenData)
                        }
                    }
                }(r)
            }(this)
        }, {}],
        2: [function(t, e) {
            var n = t("./shape"),
                i = t("./utils"),
                r = function() {
                    this._pathTemplate = "M 50,50 m 0,-{radius} a {radius},{radius} 0 1 1 0,{2radius} a {radius},{radius} 0 1 1 0,-{2radius}", n.apply(this, arguments)
                };
            r.prototype = new n, r.prototype.constructor = r, r.prototype._pathString = function(t) {
                var e = t.strokeWidth;
                t.trailWidth && t.trailWidth > t.strokeWidth && (e = t.trailWidth);
                var n = 50 - e / 2;
                return i.render(this._pathTemplate, {
                    radius: n,
                    "2radius": 2 * n
                })
            }, r.prototype._trailString = function(t) {
                return this._pathString(t)
            }, e.exports = r
        }, {
            "./shape": 6,
            "./utils": 8
        }],
        3: [function(t, e) {
            var n = t("./shape"),
                i = t("./utils"),
                r = function() {
                    this._pathTemplate = "M 0,{center} L 100,{center}", n.apply(this, arguments)
                };
            r.prototype = new n, r.prototype.constructor = r, r.prototype._initializeSvg = function(t, e) {
                t.setAttribute("viewBox", "0 0 100 " + e.strokeWidth), t.setAttribute("preserveAspectRatio", "none")
            }, r.prototype._pathString = function(t) {
                return i.render(this._pathTemplate, {
                    center: t.strokeWidth / 2
                })
            }, r.prototype._trailString = function(t) {
                return this._pathString(t)
            }, e.exports = r
        }, {
            "./shape": 6,
            "./utils": 8
        }],
        4: [function(t, e) {
            var n = t("./line"),
                i = t("./circle"),
                r = t("./square"),
                o = t("./path");
            e.exports = {
                Line: n,
                Circle: i,
                Square: r,
                Path: o
            }
        }, {
            "./circle": 2,
            "./line": 3,
            "./path": 5,
            "./square": 7
        }],
        5: [function(t, e) {
            var n = t("shifty"),
                i = t("./utils"),
                r = {
                    easeIn: "easeInCubic",
                    easeOut: "easeOutCubic",
                    easeInOut: "easeInOutCubic"
                },
                o = function(t, e) {
                    e = i.extend({
                        duration: 800,
                        easing: "linear",
                        from: {},
                        to: {},
                        step: function() {}
                    }, e), this._path = t, this._opts = e, this._tweenable = null;
                    var n = this._path.getTotalLength();
                    this._path.style.strokeDasharray = n + " " + n, this.set(0)
                };
            o.prototype.value = function() {
                var t = this._getComputedDashOffset(),
                    e = this._path.getTotalLength(),
                    n = 1 - t / e;
                return parseFloat(n.toFixed(6), 10)
            }, o.prototype.set = function(t) {
                this.stop(), this._path.style.strokeDashoffset = this._progressToOffset(t);
                var e = this._opts.step;
                if (i.isFunction(e)) {
                    var n = this._easing(this._opts.easing);
                    e(this._calculateTo(t, n), this._opts.attachment || this)
                }
            }, o.prototype.stop = function() {
                this._stopTween(), this._path.style.strokeDashoffset = this._getComputedDashOffset()
            }, o.prototype.animate = function(t, e, r) {
                e = e || {}, i.isFunction(e) && (r = e, e = {});
                var o = i.extend({}, e),
                    s = i.extend({}, this._opts);
                e = i.extend(s, e);
                var a = this._easing(e.easing),
                    l = this._resolveFromAndTo(t, a, o);
                this.stop(), this._path.getBoundingClientRect();
                var u = this._getComputedDashOffset(),
                    c = this._progressToOffset(t),
                    h = this;
                this._tweenable = new n, this._tweenable.tween({
                    from: i.extend({
                        offset: u
                    }, l.from),
                    to: i.extend({
                        offset: c
                    }, l.to),
                    duration: e.duration,
                    easing: a,
                    step: function(t) {
                        h._path.style.strokeDashoffset = t.offset, e.step(t, e.attachment)
                    },
                    finish: function() {
                        i.isFunction(r) && r()
                    }
                })
            }, o.prototype._getComputedDashOffset = function() {
                var t = window.getComputedStyle(this._path, null);
                return parseFloat(t.getPropertyValue("stroke-dashoffset"), 10)
            }, o.prototype._progressToOffset = function(t) {
                var e = this._path.getTotalLength();
                return e - t * e
            }, o.prototype._resolveFromAndTo = function(t, e, n) {
                return n.from && n.to ? {
                    from: n.from,
                    to: n.to
                } : {
                    from: this._calculateFrom(e),
                    to: this._calculateTo(t, e)
                }
            }, o.prototype._calculateFrom = function(t) {
                return n.interpolate(this._opts.from, this._opts.to, this.value(), t)
            }, o.prototype._calculateTo = function(t, e) {
                return n.interpolate(this._opts.from, this._opts.to, t, e)
            }, o.prototype._stopTween = function() {
                null !== this._tweenable && (this._tweenable.stop(), this._tweenable.dispose(), this._tweenable = null)
            }, o.prototype._easing = function(t) {
                return r.hasOwnProperty(t) ? r[t] : t
            }, e.exports = o
        }, {
            "./utils": 8,
            shifty: 1
        }],
        6: [function(t, e) {
            var n = t("./path"),
                i = t("./utils"),
                r = "Object is destroyed",
                o = function t(e, r) {
                    if (!(this instanceof t)) throw new Error("Constructor was called without new keyword");
                    if (0 !== arguments.length) {
                        this._opts = i.extend({
                            color: "#555",
                            strokeWidth: 1,
                            trailColor: null,
                            trailWidth: null,
                            fill: null,
                            text: {
                                autoStyle: !0,
                                color: null,
                                value: "",
                                className: "progressbar-text"
                            }
                        }, r, !0);
                        var o, s = this._createSvgView(this._opts);
                        if (!(o = i.isString(e) ? document.querySelector(e) : e)) throw new Error("Container does not exist: " + e);
                        this._container = o, this._container.appendChild(s.svg), this.text = null, this._opts.text.value && (this.text = this._createTextElement(this._opts, this._container), this._container.appendChild(this.text)), this.svg = s.svg, this.path = s.path, this.trail = s.trail;
                        var a = i.extend({
                            attachment: this
                        }, this._opts);
                        this._progressPath = new n(s.path, a)
                    }
                };
            o.prototype.animate = function(t, e, n) {
                if (null === this._progressPath) throw new Error(r);
                this._progressPath.animate(t, e, n)
            }, o.prototype.stop = function() {
                if (null === this._progressPath) throw new Error(r);
                void 0 !== this._progressPath && this._progressPath.stop()
            }, o.prototype.destroy = function() {
                if (null === this._progressPath) throw new Error(r);
                this.stop(), this.svg.parentNode.removeChild(this.svg), this.svg = null, this.path = null, this.trail = null, this._progressPath = null, null !== this.text && (this.text.parentNode.removeChild(this.text), this.text = null)
            }, o.prototype.set = function(t) {
                if (null === this._progressPath) throw new Error(r);
                this._progressPath.set(t)
            }, o.prototype.value = function() {
                if (null === this._progressPath) throw new Error(r);
                return void 0 === this._progressPath ? 0 : this._progressPath.value()
            }, o.prototype.setText = function(t) {
                if (null === this._progressPath) throw new Error(r);
                null === this.text && (this.text = this._createTextElement(this._opts, this._container), this._container.appendChild(this.text)), this.text.removeChild(this.text.firstChild), this.text.appendChild(document.createTextNode(t))
            }, o.prototype._createSvgView = function(t) {
                var e = document.createElementNS("http://www.w3.org/2000/svg", "svg");
                this._initializeSvg(e, t);
                var n = null;
                (t.trailColor || t.trailWidth) && (n = this._createTrail(t), e.appendChild(n));
                var i = this._createPath(t);
                return e.appendChild(i), {
                    svg: e,
                    path: i,
                    trail: n
                }
            }, o.prototype._initializeSvg = function(t) {
                t.setAttribute("viewBox", "0 0 100 100")
            }, o.prototype._createPath = function(t) {
                var e = this._pathString(t);
                return this._createPathElement(e, t)
            }, o.prototype._createTrail = function(t) {
                var e = this._trailString(t),
                    n = i.extend({}, t);
                return n.trailColor || (n.trailColor = "#eee"), n.trailWidth || (n.trailWidth = n.strokeWidth), n.color = n.trailColor, n.strokeWidth = n.trailWidth, n.fill = null, this._createPathElement(e, n)
            }, o.prototype._createPathElement = function(t, e) {
                var n = document.createElementNS("http://www.w3.org/2000/svg", "path");
                return n.setAttribute("d", t), n.setAttribute("stroke", e.color), n.setAttribute("stroke-width", e.strokeWidth), e.fill ? n.setAttribute("fill", e.fill) : n.setAttribute("fill-opacity", "0"), n
            }, o.prototype._createTextElement = function(t, e) {
                var n = document.createElement("p");
                return n.appendChild(document.createTextNode(t.text.value)), t.text.autoStyle && (e.style.position = "relative", n.style.position = "absolute", n.style.top = "50%", n.style.left = "50%", n.style.padding = 0, n.style.margin = 0, i.setStyle(n, "transform", "translate(-50%, -50%)"), n.style.color = t.text.color ? t.text.color : t.color), n.className = t.text.className, n
            }, o.prototype._pathString = function() {
                throw new Error("Override this function for each progress bar")
            }, o.prototype._trailString = function() {
                throw new Error("Override this function for each progress bar")
            }, e.exports = o
        }, {
            "./path": 5,
            "./utils": 8
        }],
        7: [function(t, e) {
            var n = t("./shape"),
                i = t("./utils"),
                r = function() {
                    this._pathTemplate = "M 0,{halfOfStrokeWidth} L {width},{halfOfStrokeWidth} L {width},{width} L {halfOfStrokeWidth},{width} L {halfOfStrokeWidth},{strokeWidth}", this._trailTemplate = "M {startMargin},{halfOfStrokeWidth} L {width},{halfOfStrokeWidth} L {width},{width} L {halfOfStrokeWidth},{width} L {halfOfStrokeWidth},{halfOfStrokeWidth}", n.apply(this, arguments)
                };
            r.prototype = new n, r.prototype.constructor = r, r.prototype._pathString = function(t) {
                var e = 100 - t.strokeWidth / 2;
                return i.render(this._pathTemplate, {
                    width: e,
                    strokeWidth: t.strokeWidth,
                    halfOfStrokeWidth: t.strokeWidth / 2
                })
            }, r.prototype._trailString = function(t) {
                var e = 100 - t.strokeWidth / 2;
                return i.render(this._trailTemplate, {
                    width: e,
                    strokeWidth: t.strokeWidth,
                    halfOfStrokeWidth: t.strokeWidth / 2,
                    startMargin: t.strokeWidth / 2 - t.trailWidth / 2
                })
            }, e.exports = r
        }, {
            "./shape": 6,
            "./utils": 8
        }],
        8: [function(t, e) {
            function n(t, e, i) {
                t = t || {}, e = e || {}, i = i || !1;
                for (var r in e)
                    if (e.hasOwnProperty(r)) {
                        var o = t[r],
                            s = e[r];
                        t[r] = i && u(o) && u(s) ? n(o, s, i) : s
                    } return t
            }

            function i(t, e) {
                var n = t;
                for (var i in e)
                    if (e.hasOwnProperty(i)) {
                        var r = e[i],
                            o = "\\{" + i + "\\}",
                            s = new RegExp(o, "g");
                        n = n.replace(s, r)
                    } return n
            }

            function r(t, e, n) {
                for (var i = 0; i < c.length; ++i) {
                    var r = o(c[i]);
                    t.style[r + o(e)] = n
                }
                t.style[e] = n
            }

            function o(t) {
                return t.charAt(0).toUpperCase() + t.slice(1)
            }

            function s(t) {
                return "string" == typeof t || t instanceof String
            }

            function a(t) {
                return "function" == typeof t
            }

            function l(t) {
                return "[object Array]" === Object.prototype.toString.call(t)
            }

            function u(t) {
                return !l(t) && ("object" == typeof t && !!t)
            }
            var c = "webkit moz o ms".split(" ");
            e.exports = {
                extend: n,
                render: i,
                setStyle: r,
                capitalize: o,
                isString: s,
                isFunction: a,
                isObject: u
            }
        }, {}]
    }, {}, [4])(4)
}),
function(t) {
    if ("object" == typeof exports && "undefined" != typeof module) module.exports = t();
    else if ("function" == typeof define && define.amd) define([], t);
    else {
        var e;
        e = "undefined" != typeof window ? window : "undefined" != typeof global ? global : "undefined" != typeof self ? self : this, e.JSZip = t()
    }
}(function() {
    return function t(e, n, i) {
        function r(s, a) {
            if (!n[s]) {
                if (!e[s]) {
                    var l = "function" == typeof require && require;
                    if (!a && l) return l(s, !0);
                    if (o) return o(s, !0);
                    var u = new Error("Cannot find module '" + s + "'");
                    throw u.code = "MODULE_NOT_FOUND", u
                }
                var c = n[s] = {
                    exports: {}
                };
                e[s][0].call(c.exports, function(t) {
                    var n = e[s][1][t];
                    return r(n || t)
                }, c, c.exports, t, e, n, i)
            }
            return n[s].exports
        }
        for (var o = "function" == typeof require && require, s = 0; s < i.length; s++) r(i[s]);
        return r
    }({
        1: [function(t, e, n) {
            "use strict";
            var i = t("./utils"),
                r = t("./support"),
                o = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=";
            n.encode = function(t) {
                for (var e, n, r, s, a, l, u, c = [], h = 0, d = t.length, f = d, p = "string" !== i.getTypeOf(t); h < t.length;) f = d - h, p ? (e = t[h++], n = h < d ? t[h++] : 0, r = h < d ? t[h++] : 0) : (e = t.charCodeAt(h++), n = h < d ? t.charCodeAt(h++) : 0, r = h < d ? t.charCodeAt(h++) : 0), s = e >> 2, a = (3 & e) << 4 | n >> 4, l = f > 1 ? (15 & n) << 2 | r >> 6 : 64, u = f > 2 ? 63 & r : 64, c.push(o.charAt(s) + o.charAt(a) + o.charAt(l) + o.charAt(u));
                return c.join("")
            }, n.decode = function(t) {
                var e, n, i, s, a, l, u, c = 0,
                    h = 0,
                    d = "data:";
                if (t.substr(d.length) === d) throw new Error("Invalid base64 input, it looks like a data url.");
                t = t.replace(/[^A-Za-z0-9\+\/\=]/g, "");
                var f = 3 * t.length / 4;
                if (t.charAt(t.length - 1) === o.charAt(64) && f--, t.charAt(t.length - 2) === o.charAt(64) && f--, f % 1 != 0) throw new Error("Invalid base64 input, bad content length.");
                var p;
                for (p = r.uint8array ? new Uint8Array(0 | f) : new Array(0 | f); c < t.length;) s = o.indexOf(t.charAt(c++)), a = o.indexOf(t.charAt(c++)), l = o.indexOf(t.charAt(c++)), u = o.indexOf(t.charAt(c++)), e = s << 2 | a >> 4, n = (15 & a) << 4 | l >> 2, i = (3 & l) << 6 | u, p[h++] = e, 64 !== l && (p[h++] = n), 64 !== u && (p[h++] = i);
                return p
            }
        }, {
            "./support": 30,
            "./utils": 32
        }],
        2: [function(t, e, n) {
            "use strict";

            function i(t, e, n, i, r) {
                this.compressedSize = t, this.uncompressedSize = e, this.crc32 = n, this.compression = i, this.compressedContent = r
            }
            var r = t("./external"),
                o = t("./stream/DataWorker"),
                s = t("./stream/DataLengthProbe"),
                a = t("./stream/Crc32Probe"),
                s = t("./stream/DataLengthProbe");
            i.prototype = {
                getContentWorker: function() {
                    var t = new o(r.Promise.resolve(this.compressedContent)).pipe(this.compression.uncompressWorker()).pipe(new s("data_length")),
                        e = this;
                    return t.on("end", function() {
                        if (this.streamInfo.data_length !== e.uncompressedSize) throw new Error("Bug : uncompressed data size mismatch")
                    }), t
                },
                getCompressedWorker: function() {
                    return new o(r.Promise.resolve(this.compressedContent)).withStreamInfo("compressedSize", this.compressedSize).withStreamInfo("uncompressedSize", this.uncompressedSize).withStreamInfo("crc32", this.crc32).withStreamInfo("compression", this.compression)
                }
            }, i.createWorkerFrom = function(t, e, n) {
                return t.pipe(new a).pipe(new s("uncompressedSize")).pipe(e.compressWorker(n)).pipe(new s("compressedSize")).withStreamInfo("compression", e)
            }, e.exports = i
        }, {
            "./external": 6,
            "./stream/Crc32Probe": 25,
            "./stream/DataLengthProbe": 26,
            "./stream/DataWorker": 27
        }],
        3: [function(t, e, n) {
            "use strict";
            var i = t("./stream/GenericWorker");
            n.STORE = {
                magic: "\0\0",
                compressWorker: function(t) {
                    return new i("STORE compression")
                },
                uncompressWorker: function() {
                    return new i("STORE decompression")
                }
            }, n.DEFLATE = t("./flate")
        }, {
            "./flate": 7,
            "./stream/GenericWorker": 28
        }],
        4: [function(t, e, n) {
            "use strict";

            function i(t, e, n, i) {
                var r = s,
                    o = i + n;
                t ^= -1;
                for (var a = i; a < o; a++) t = t >>> 8 ^ r[255 & (t ^ e[a])];
                return -1 ^ t
            }

            function r(t, e, n, i) {
                var r = s,
                    o = i + n;
                t ^= -1;
                for (var a = i; a < o; a++) t = t >>> 8 ^ r[255 & (t ^ e.charCodeAt(a))];
                return -1 ^ t
            }
            var o = t("./utils"),
                s = function() {
                    for (var t, e = [], n = 0; n < 256; n++) {
                        t = n;
                        for (var i = 0; i < 8; i++) t = 1 & t ? 3988292384 ^ t >>> 1 : t >>> 1;
                        e[n] = t
                    }
                    return e
                }();
            e.exports = function(t, e) {
                return void 0 !== t && t.length ? "string" !== o.getTypeOf(t) ? i(0 | e, t, t.length, 0) : r(0 | e, t, t.length, 0) : 0
            }
        }, {
            "./utils": 32
        }],
        5: [function(t, e, n) {
            "use strict";
            n.base64 = !1, n.binary = !1, n.dir = !1, n.createFolders = !0, n.date = null, n.compression = null, n.compressionOptions = null, n.comment = null, n.unixPermissions = null, n.dosPermissions = null
        }, {}],
        6: [function(t, e, n) {
            "use strict";
            var i = null;
            i = "undefined" != typeof Promise ? Promise : t("lie"), e.exports = {
                Promise: i
            }
        }, {
            lie: 58
        }],
        7: [function(t, e, n) {
            "use strict";

            function i(t, e) {
                a.call(this, "FlateWorker/" + t), this._pako = new o[t]({
                    raw: !0,
                    level: e.level || -1
                }), this.meta = {};
                var n = this;
                this._pako.onData = function(t) {
                    n.push({
                        data: t,
                        meta: n.meta
                    })
                }
            }
            var r = "undefined" != typeof Uint8Array && "undefined" != typeof Uint16Array && "undefined" != typeof Uint32Array,
                o = t("pako"),
                s = t("./utils"),
                a = t("./stream/GenericWorker"),
                l = r ? "uint8array" : "array";
            n.magic = "\b\0", s.inherits(i, a), i.prototype.processChunk = function(t) {
                this.meta = t.meta, this._pako.push(s.transformTo(l, t.data), !1)
            }, i.prototype.flush = function() {
                a.prototype.flush.call(this), this._pako.push([], !0)
            }, i.prototype.cleanUp = function() {
                a.prototype.cleanUp.call(this), this._pako = null
            }, n.compressWorker = function(t) {
                return new i("Deflate", t)
            }, n.uncompressWorker = function() {
                return new i("Inflate", {})
            }
        }, {
            "./stream/GenericWorker": 28,
            "./utils": 32,
            pako: 59
        }],
        8: [function(t, e, n) {
            "use strict";

            function i(t, e, n, i) {
                o.call(this, "ZipFileWorker"), this.bytesWritten = 0, this.zipComment = e, this.zipPlatform = n, this.encodeFileName = i, this.streamFiles = t, this.accumulate = !1, this.contentBuffer = [], this.dirRecords = [], this.currentSourceOffset = 0, this.entriesCount = 0, this.currentFile = null, this._sources = []
            }
            var r = t("../utils"),
                o = t("../stream/GenericWorker"),
                s = t("../utf8"),
                a = t("../crc32"),
                l = t("../signature"),
                u = function(t, e) {
                    var n, i = "";
                    for (n = 0; n < e; n++) i += String.fromCharCode(255 & t), t >>>= 8;
                    return i
                },
                c = function(t, e) {
                    var n = t;
                    return t || (n = e ? 16893 : 33204), (65535 & n) << 16
                },
                h = function(t, e) {
                    return 63 & (t || 0)
                },
                d = function(t, e, n, i, o, d) {
                    var f, p, m = t.file,
                        g = t.compression,
                        v = d !== s.utf8encode,
                        y = r.transformTo("string", d(m.name)),
                        b = r.transformTo("string", s.utf8encode(m.name)),
                        _ = m.comment,
                        w = r.transformTo("string", d(_)),
                        x = r.transformTo("string", s.utf8encode(_)),
                        k = b.length !== m.name.length,
                        C = x.length !== _.length,
                        E = "",
                        T = "",
                        S = "",
                        A = m.dir,
                        N = m.date,
                        D = {
                            crc32: 0,
                            compressedSize: 0,
                            uncompressedSize: 0
                        };
                    e && !n || (D.crc32 = t.crc32, D.compressedSize = t.compressedSize, D.uncompressedSize = t.uncompressedSize);
                    var O = 0;
                    e && (O |= 8), v || !k && !C || (O |= 2048);
                    var I = 0,
                        z = 0;
                    A && (I |= 16), "UNIX" === o ? (z = 798, I |= c(m.unixPermissions, A)) : (z = 20, I |= h(m.dosPermissions)), f = N.getUTCHours(), f <<= 6, f |= N.getUTCMinutes(), f <<= 5, f |= N.getUTCSeconds() / 2, p = N.getUTCFullYear() - 1980, p <<= 4, p |= N.getUTCMonth() + 1, p <<= 5, p |= N.getUTCDate(), k && (T = u(1, 1) + u(a(y), 4) + b, E += "up" + u(T.length, 2) + T), C && (S = u(1, 1) + u(a(w), 4) + x, E += "uc" + u(S.length, 2) + S);
                    var L = "";
                    return L += "\n\0", L += u(O, 2), L += g.magic, L += u(f, 2), L += u(p, 2), L += u(D.crc32, 4), L += u(D.compressedSize, 4), L += u(D.uncompressedSize, 4), L += u(y.length, 2), L += u(E.length, 2), {
                        fileRecord: l.LOCAL_FILE_HEADER + L + y + E,
                        dirRecord: l.CENTRAL_FILE_HEADER + u(z, 2) + L + u(w.length, 2) + "\0\0\0\0" + u(I, 4) + u(i, 4) + y + E + w
                    }
                },
                f = function(t, e, n, i, o) {
                    var s = r.transformTo("string", o(i));
                    return l.CENTRAL_DIRECTORY_END + "\0\0\0\0" + u(t, 2) + u(t, 2) + u(e, 4) + u(n, 4) + u(s.length, 2) + s
                },
                p = function(t) {
                    return l.DATA_DESCRIPTOR + u(t.crc32, 4) + u(t.compressedSize, 4) + u(t.uncompressedSize, 4)
                };
            r.inherits(i, o), i.prototype.push = function(t) {
                var e = t.meta.percent || 0,
                    n = this.entriesCount,
                    i = this._sources.length;
                this.accumulate ? this.contentBuffer.push(t) : (this.bytesWritten += t.data.length, o.prototype.push.call(this, {
                    data: t.data,
                    meta: {
                        currentFile: this.currentFile,
                        percent: n ? (e + 100 * (n - i - 1)) / n : 100
                    }
                }))
            }, i.prototype.openedSource = function(t) {
                this.currentSourceOffset = this.bytesWritten, this.currentFile = t.file.name;
                var e = this.streamFiles && !t.file.dir;
                if (e) {
                    var n = d(t, e, !1, this.currentSourceOffset, this.zipPlatform, this.encodeFileName);
                    this.push({
                        data: n.fileRecord,
                        meta: {
                            percent: 0
                        }
                    })
                } else this.accumulate = !0
            }, i.prototype.closedSource = function(t) {
                this.accumulate = !1;
                var e = this.streamFiles && !t.file.dir,
                    n = d(t, e, !0, this.currentSourceOffset, this.zipPlatform, this.encodeFileName);
                if (this.dirRecords.push(n.dirRecord), e) this.push({
                    data: p(t),
                    meta: {
                        percent: 100
                    }
                });
                else
                    for (this.push({
                            data: n.fileRecord,
                            meta: {
                                percent: 0
                            }
                        }); this.contentBuffer.length;) this.push(this.contentBuffer.shift());
                this.currentFile = null
            }, i.prototype.flush = function() {
                for (var t = this.bytesWritten, e = 0; e < this.dirRecords.length; e++) this.push({
                    data: this.dirRecords[e],
                    meta: {
                        percent: 100
                    }
                });
                var n = this.bytesWritten - t,
                    i = f(this.dirRecords.length, n, t, this.zipComment, this.encodeFileName);
                this.push({
                    data: i,
                    meta: {
                        percent: 100
                    }
                })
            }, i.prototype.prepareNextSource = function() {
                this.previous = this._sources.shift(), this.openedSource(this.previous.streamInfo), this.isPaused ? this.previous.pause() : this.previous.resume()
            }, i.prototype.registerPrevious = function(t) {
                this._sources.push(t);
                var e = this;
                return t.on("data", function(t) {
                    e.processChunk(t)
                }), t.on("end", function() {
                    e.closedSource(e.previous.streamInfo), e._sources.length ? e.prepareNextSource() : e.end()
                }), t.on("error", function(t) {
                    e.error(t)
                }), this
            }, i.prototype.resume = function() {
                return !!o.prototype.resume.call(this) && (!this.previous && this._sources.length ? (this.prepareNextSource(), !0) : this.previous || this._sources.length || this.generatedError ? void 0 : (this.end(), !0))
            }, i.prototype.error = function(t) {
                var e = this._sources;
                if (!o.prototype.error.call(this, t)) return !1;
                for (var n = 0; n < e.length; n++) try {
                    e[n].error(t)
                } catch (t) {}
                return !0
            }, i.prototype.lock = function() {
                o.prototype.lock.call(this);
                for (var t = this._sources, e = 0; e < t.length; e++) t[e].lock()
            }, e.exports = i
        }, {
            "../crc32": 4,
            "../signature": 23,
            "../stream/GenericWorker": 28,
            "../utf8": 31,
            "../utils": 32
        }],
        9: [function(t, e, n) {
            "use strict";
            var i = t("../compressions"),
                r = t("./ZipFileWorker"),
                o = function(t, e) {
                    var n = t || e,
                        r = i[n];
                    if (!r) throw new Error(n + " is not a valid compression method !");
                    return r
                };
            n.generateWorker = function(t, e, n) {
                var i = new r(e.streamFiles, n, e.platform, e.encodeFileName),
                    s = 0;
                try {
                    t.forEach(function(t, n) {
                        s++;
                        var r = o(n.options.compression, e.compression),
                            a = n.options.compressionOptions || e.compressionOptions || {},
                            l = n.dir,
                            u = n.date;
                        n._compressWorker(r, a).withStreamInfo("file", {
                            name: t,
                            dir: l,
                            date: u,
                            comment: n.comment || "",
                            unixPermissions: n.unixPermissions,
                            dosPermissions: n.dosPermissions
                        }).pipe(i)
                    }), i.entriesCount = s
                } catch (t) {
                    i.error(t)
                }
                return i
            }
        }, {
            "../compressions": 3,
            "./ZipFileWorker": 8
        }],
        10: [function(t, e, n) {
            "use strict";

            function i() {
                if (!(this instanceof i)) return new i;
                if (arguments.length) throw new Error("The constructor with parameters has been removed in JSZip 3.0, please check the upgrade guide.");
                this.files = {}, this.comment = null, this.root = "", this.clone = function() {
                    var t = new i;
                    for (var e in this) "function" != typeof this[e] && (t[e] = this[e]);
                    return t
                }
            }
            i.prototype = t("./object"), i.prototype.loadAsync = t("./load"), i.support = t("./support"), i.defaults = t("./defaults"), i.version = "3.1.2", i.loadAsync = function(t, e) {
                return (new i).loadAsync(t, e)
            }, i.external = t("./external"), e.exports = i
        }, {
            "./defaults": 5,
            "./external": 6,
            "./load": 11,
            "./object": 15,
            "./support": 30
        }],
        11: [function(t, e, n) {
            "use strict";

            function i(t) {
                return new o.Promise(function(e, n) {
                    var i = t.decompressed.getContentWorker().pipe(new l);
                    i.on("error", function(t) {
                        n(t)
                    }).on("end", function() {
                        i.streamInfo.crc32 !== t.decompressed.crc32 ? n(new Error("Corrupted zip : CRC32 mismatch")) : e()
                    }).resume()
                })
            }
            var r = t("./utils"),
                o = t("./external"),
                s = t("./utf8"),
                r = t("./utils"),
                a = t("./zipEntries"),
                l = t("./stream/Crc32Probe"),
                u = t("./nodejsUtils");
            e.exports = function(t, e) {
                var n = this;
                return e = r.extend(e || {}, {
                    base64: !1,
                    checkCRC32: !1,
                    optimizedBinaryString: !1,
                    createFolders: !1,
                    decodeFileName: s.utf8decode
                }), u.isNode && u.isStream(t) ? o.Promise.reject(new Error("JSZip can't accept a stream when loading a zip file.")) : r.prepareContent("the loaded zip file", t, !0, e.optimizedBinaryString, e.base64).then(function(t) {
                    var n = new a(e);
                    return n.load(t), n
                }).then(function(t) {
                    var n = [o.Promise.resolve(t)],
                        r = t.files;
                    if (e.checkCRC32)
                        for (var s = 0; s < r.length; s++) n.push(i(r[s]));
                    return o.Promise.all(n)
                }).then(function(t) {
                    for (var i = t.shift(), r = i.files, o = 0; o < r.length; o++) {
                        var s = r[o];
                        n.file(s.fileNameStr, s.decompressed, {
                            binary: !0,
                            optimizedBinaryString: !0,
                            date: s.date,
                            dir: s.dir,
                            comment: s.fileCommentStr.length ? s.fileCommentStr : null,
                            unixPermissions: s.unixPermissions,
                            dosPermissions: s.dosPermissions,
                            createFolders: e.createFolders
                        })
                    }
                    return i.zipComment.length && (n.comment = i.zipComment), n
                })
            }
        }, {
            "./external": 6,
            "./nodejsUtils": 14,
            "./stream/Crc32Probe": 25,
            "./utf8": 31,
            "./utils": 32,
            "./zipEntries": 33
        }],
        12: [function(t, e, n) {
            "use strict";

            function i(t, e) {
                o.call(this, "Nodejs stream input adapter for " + t), this._upstreamEnded = !1, this._bindStream(e)
            }
            var r = t("../utils"),
                o = t("../stream/GenericWorker");
            r.inherits(i, o), i.prototype._bindStream = function(t) {
                var e = this;
                this._stream = t, t.pause(), t.on("data", function(t) {
                    e.push({
                        data: t,
                        meta: {
                            percent: 0
                        }
                    })
                }).on("error", function(t) {
                    e.isPaused ? this.generatedError = t : e.error(t)
                }).on("end", function() {
                    e.isPaused ? e._upstreamEnded = !0 : e.end()
                })
            }, i.prototype.pause = function() {
                return !!o.prototype.pause.call(this) && (this._stream.pause(), !0)
            }, i.prototype.resume = function() {
                return !!o.prototype.resume.call(this) && (this._upstreamEnded ? this.end() : this._stream.resume(), !0)
            }, e.exports = i
        }, {
            "../stream/GenericWorker": 28,
            "../utils": 32
        }],
        13: [function(t, e, n) {
            "use strict";

            function i(t, e, n) {
                r.call(this, e), this._helper = t;
                var i = this;
                t.on("data", function(t, e) {
                    i.push(t) || i._helper.pause(), n && n(e)
                }).on("error", function(t) {
                    i.emit("error", t)
                }).on("end", function() {
                    i.push(null)
                })
            }
            var r = t("readable-stream").Readable;
            t("util").inherits(i, r), i.prototype._read = function() {
                this._helper.resume()
            }, e.exports = i
        }, {
            "readable-stream": 16,
            util: void 0
        }],
        14: [function(t, e, n) {
            "use strict";
            e.exports = {
                isNode: "undefined" != typeof Buffer,
                newBuffer: function(t, e) {
                    return new Buffer(t, e)
                },
                isBuffer: function(t) {
                    return Buffer.isBuffer(t)
                },
                isStream: function(t) {
                    return t && "function" == typeof t.on && "function" == typeof t.pause && "function" == typeof t.resume
                }
            }
        }, {}],
        15: [function(t, e, n) {
            "use strict";

            function i(t) {
                return "[object RegExp]" === Object.prototype.toString.call(t)
            }
            var r = t("./utf8"),
                o = t("./utils"),
                s = t("./stream/GenericWorker"),
                a = t("./stream/StreamHelper"),
                l = t("./defaults"),
                u = t("./compressedObject"),
                c = t("./zipObject"),
                h = t("./generate"),
                d = t("./nodejsUtils"),
                f = t("./nodejs/NodejsStreamInputAdapter"),
                p = function(t, e, n) {
                    var i, r = o.getTypeOf(e),
                        a = o.extend(n || {}, l);
                    a.date = a.date || new Date, null !== a.compression && (a.compression = a.compression.toUpperCase()), "string" == typeof a.unixPermissions && (a.unixPermissions = parseInt(a.unixPermissions, 8)), a.unixPermissions && 16384 & a.unixPermissions && (a.dir = !0), a.dosPermissions && 16 & a.dosPermissions && (a.dir = !0), a.dir && (t = g(t)), a.createFolders && (i = m(t)) && v.call(this, i, !0);
                    var h = "string" === r && !1 === a.binary && !1 === a.base64;
                    n && void 0 !== n.binary || (a.binary = !h), (e instanceof u && 0 === e.uncompressedSize || a.dir || !e || 0 === e.length) && (a.base64 = !1, a.binary = !0, e = "", a.compression = "STORE", r = "string");
                    var p = null;
                    p = e instanceof u || e instanceof s ? e : d.isNode && d.isStream(e) ? new f(t, e) : o.prepareContent(t, e, a.binary, a.optimizedBinaryString, a.base64);
                    var y = new c(t, p, a);
                    this.files[t] = y
                },
                m = function(t) {
                    "/" === t.slice(-1) && (t = t.substring(0, t.length - 1));
                    var e = t.lastIndexOf("/");
                    return e > 0 ? t.substring(0, e) : ""
                },
                g = function(t) {
                    return "/" !== t.slice(-1) && (t += "/"), t
                },
                v = function(t, e) {
                    return e = void 0 !== e ? e : l.createFolders, t = g(t), this.files[t] || p.call(this, t, null, {
                        dir: !0,
                        createFolders: e
                    }), this.files[t]
                },
                y = {
                    load: function() {
                        throw new Error("This method has been removed in JSZip 3.0, please check the upgrade guide.")
                    },
                    forEach: function(t) {
                        var e, n, i;
                        for (e in this.files) this.files.hasOwnProperty(e) && (i = this.files[e], (n = e.slice(this.root.length, e.length)) && e.slice(0, this.root.length) === this.root && t(n, i))
                    },
                    filter: function(t) {
                        var e = [];
                        return this.forEach(function(n, i) {
                            t(n, i) && e.push(i)
                        }), e
                    },
                    file: function(t, e, n) {
                        if (1 === arguments.length) {
                            if (i(t)) {
                                var r = t;
                                return this.filter(function(t, e) {
                                    return !e.dir && r.test(t)
                                })
                            }
                            var o = this.files[this.root + t];
                            return o && !o.dir ? o : null
                        }
                        return t = this.root + t, p.call(this, t, e, n), this
                    },
                    folder: function(t) {
                        if (!t) return this;
                        if (i(t)) return this.filter(function(e, n) {
                            return n.dir && t.test(e)
                        });
                        var e = this.root + t,
                            n = v.call(this, e),
                            r = this.clone();
                        return r.root = n.name, r
                    },
                    remove: function(t) {
                        t = this.root + t;
                        var e = this.files[t];
                        if (e || ("/" !== t.slice(-1) && (t += "/"), e = this.files[t]), e && !e.dir) delete this.files[t];
                        else
                            for (var n = this.filter(function(e, n) {
                                    return n.name.slice(0, t.length) === t
                                }), i = 0; i < n.length; i++) delete this.files[n[i].name];
                        return this
                    },
                    generate: function(t) {
                        throw new Error("This method has been removed in JSZip 3.0, please check the upgrade guide.")
                    },
                    generateInternalStream: function(t) {
                        var e, n = {};
                        try {
                            if (n = o.extend(t || {}, {
                                    streamFiles: !1,
                                    compression: "STORE",
                                    compressionOptions: null,
                                    type: "",
                                    platform: "DOS",
                                    comment: null,
                                    mimeType: "application/zip",
                                    encodeFileName: r.utf8encode
                                }), n.type = n.type.toLowerCase(), n.compression = n.compression.toUpperCase(), "binarystring" === n.type && (n.type = "string"), !n.type) throw new Error("No output type specified.");
                            o.checkSupport(n.type), "darwin" !== n.platform && "freebsd" !== n.platform && "linux" !== n.platform && "sunos" !== n.platform || (n.platform = "UNIX"), "win32" === n.platform && (n.platform = "DOS");
                            var i = n.comment || this.comment || "";
                            e = h.generateWorker(this, n, i)
                        } catch (t) {
                            e = new s("error"), e.error(t)
                        }
                        return new a(e, n.type || "string", n.mimeType)
                    },
                    generateAsync: function(t, e) {
                        return this.generateInternalStream(t).accumulate(e)
                    },
                    generateNodeStream: function(t, e) {
                        return t = t || {}, t.type || (t.type = "nodebuffer"), this.generateInternalStream(t).toNodejsStream(e)
                    }
                };
            e.exports = y
        }, {
            "./compressedObject": 2,
            "./defaults": 5,
            "./generate": 9,
            "./nodejs/NodejsStreamInputAdapter": 12,
            "./nodejsUtils": 14,
            "./stream/GenericWorker": 28,
            "./stream/StreamHelper": 29,
            "./utf8": 31,
            "./utils": 32,
            "./zipObject": 35
        }],
        16: [function(t, e, n) {
            e.exports = t("stream")
        }, {
            stream: void 0
        }],
        17: [function(t, e, n) {
            "use strict";

            function i(t) {
                r.call(this, t);
                for (var e = 0; e < this.data.length; e++) t[e] = 255 & t[e]
            }
            var r = t("./DataReader");
            t("../utils").inherits(i, r), i.prototype.byteAt = function(t) {
                return this.data[this.zero + t]
            }, i.prototype.lastIndexOfSignature = function(t) {
                for (var e = t.charCodeAt(0), n = t.charCodeAt(1), i = t.charCodeAt(2), r = t.charCodeAt(3), o = this.length - 4; o >= 0; --o)
                    if (this.data[o] === e && this.data[o + 1] === n && this.data[o + 2] === i && this.data[o + 3] === r) return o - this.zero;
                return -1
            }, i.prototype.readAndCheckSignature = function(t) {
                var e = t.charCodeAt(0),
                    n = t.charCodeAt(1),
                    i = t.charCodeAt(2),
                    r = t.charCodeAt(3),
                    o = this.readData(4);
                return e === o[0] && n === o[1] && i === o[2] && r === o[3]
            }, i.prototype.readData = function(t) {
                if (this.checkOffset(t), 0 === t) return [];
                var e = this.data.slice(this.zero + this.index, this.zero + this.index + t);
                return this.index += t, e
            }, e.exports = i
        }, {
            "../utils": 32,
            "./DataReader": 18
        }],
        18: [function(t, e, n) {
            "use strict";

            function i(t) {
                this.data = t, this.length = t.length, this.index = 0, this.zero = 0
            }
            var r = t("../utils");
            i.prototype = {
                checkOffset: function(t) {
                    this.checkIndex(this.index + t)
                },
                checkIndex: function(t) {
                    if (this.length < this.zero + t || t < 0) throw new Error("End of data reached (data length = " + this.length + ", asked index = " + t + "). Corrupted zip ?")
                },
                setIndex: function(t) {
                    this.checkIndex(t), this.index = t
                },
                skip: function(t) {
                    this.setIndex(this.index + t)
                },
                byteAt: function(t) {},
                readInt: function(t) {
                    var e, n = 0;
                    for (this.checkOffset(t), e = this.index + t - 1; e >= this.index; e--) n = (n << 8) + this.byteAt(e);
                    return this.index += t, n
                },
                readString: function(t) {
                    return r.transformTo("string", this.readData(t))
                },
                readData: function(t) {},
                lastIndexOfSignature: function(t) {},
                readAndCheckSignature: function(t) {},
                readDate: function() {
                    var t = this.readInt(4);
                    return new Date(Date.UTC(1980 + (t >> 25 & 127), (t >> 21 & 15) - 1, t >> 16 & 31, t >> 11 & 31, t >> 5 & 63, (31 & t) << 1))
                }
            }, e.exports = i
        }, {
            "../utils": 32
        }],
        19: [function(t, e, n) {
            "use strict";

            function i(t) {
                r.call(this, t)
            }
            var r = t("./Uint8ArrayReader");
            t("../utils").inherits(i, r), i.prototype.readData = function(t) {
                this.checkOffset(t);
                var e = this.data.slice(this.zero + this.index, this.zero + this.index + t);
                return this.index += t, e
            }, e.exports = i
        }, {
            "../utils": 32,
            "./Uint8ArrayReader": 21
        }],
        20: [function(t, e, n) {
            "use strict";

            function i(t) {
                r.call(this, t)
            }
            var r = t("./DataReader");
            t("../utils").inherits(i, r), i.prototype.byteAt = function(t) {
                return this.data.charCodeAt(this.zero + t)
            }, i.prototype.lastIndexOfSignature = function(t) {
                return this.data.lastIndexOf(t) - this.zero
            }, i.prototype.readAndCheckSignature = function(t) {
                return t === this.readData(4)
            }, i.prototype.readData = function(t) {
                this.checkOffset(t);
                var e = this.data.slice(this.zero + this.index, this.zero + this.index + t);
                return this.index += t, e
            }, e.exports = i
        }, {
            "../utils": 32,
            "./DataReader": 18
        }],
        21: [function(t, e, n) {
            "use strict";

            function i(t) {
                r.call(this, t)
            }
            var r = t("./ArrayReader");
            t("../utils").inherits(i, r), i.prototype.readData = function(t) {
                if (this.checkOffset(t), 0 === t) return new Uint8Array(0);
                var e = this.data.subarray(this.zero + this.index, this.zero + this.index + t);
                return this.index += t, e
            }, e.exports = i
        }, {
            "../utils": 32,
            "./ArrayReader": 17
        }],
        22: [function(t, e, n) {
            "use strict";
            var i = t("../utils"),
                r = t("../support"),
                o = t("./ArrayReader"),
                s = t("./StringReader"),
                a = t("./NodeBufferReader"),
                l = t("./Uint8ArrayReader");
            e.exports = function(t) {
                var e = i.getTypeOf(t);
                return i.checkSupport(e), "string" !== e || r.uint8array ? "nodebuffer" === e ? new a(t) : r.uint8array ? new l(i.transformTo("uint8array", t)) : new o(i.transformTo("array", t)) : new s(t)
            }
        }, {
            "../support": 30,
            "../utils": 32,
            "./ArrayReader": 17,
            "./NodeBufferReader": 19,
            "./StringReader": 20,
            "./Uint8ArrayReader": 21
        }],
        23: [function(t, e, n) {
            "use strict";
            n.LOCAL_FILE_HEADER = "PK", n.CENTRAL_FILE_HEADER = "PK", n.CENTRAL_DIRECTORY_END = "PK", n.ZIP64_CENTRAL_DIRECTORY_LOCATOR = "PK", n.ZIP64_CENTRAL_DIRECTORY_END = "PK", n.DATA_DESCRIPTOR = "PK\b"
        }, {}],
        24: [function(t, e, n) {
            "use strict";

            function i(t) {
                r.call(this, "ConvertWorker to " + t), this.destType = t
            }
            var r = t("./GenericWorker"),
                o = t("../utils");
            o.inherits(i, r), i.prototype.processChunk = function(t) {
                this.push({
                    data: o.transformTo(this.destType, t.data),
                    meta: t.meta
                })
            }, e.exports = i
        }, {
            "../utils": 32,
            "./GenericWorker": 28
        }],
        25: [function(t, e, n) {
            "use strict";

            function i() {
                r.call(this, "Crc32Probe")
            }
            var r = t("./GenericWorker"),
                o = t("../crc32");
            t("../utils").inherits(i, r), i.prototype.processChunk = function(t) {
                this.streamInfo.crc32 = o(t.data, this.streamInfo.crc32 || 0), this.push(t)
            }, e.exports = i
        }, {
            "../crc32": 4,
            "../utils": 32,
            "./GenericWorker": 28
        }],
        26: [function(t, e, n) {
            "use strict";

            function i(t) {
                o.call(this, "DataLengthProbe for " + t), this.propName = t, this.withStreamInfo(t, 0)
            }
            var r = t("../utils"),
                o = t("./GenericWorker");
            r.inherits(i, o), i.prototype.processChunk = function(t) {
                if (t) {
                    var e = this.streamInfo[this.propName] || 0;
                    this.streamInfo[this.propName] = e + t.data.length
                }
                o.prototype.processChunk.call(this, t)
            }, e.exports = i
        }, {
            "../utils": 32,
            "./GenericWorker": 28
        }],
        27: [function(t, e, n) {
            "use strict";

            function i(t) {
                o.call(this, "DataWorker");
                var e = this;
                this.dataIsReady = !1, this.index = 0, this.max = 0, this.data = null, this.type = "", this._tickScheduled = !1, t.then(function(t) {
                    e.dataIsReady = !0, e.data = t, e.max = t && t.length || 0, e.type = r.getTypeOf(t), e.isPaused || e._tickAndRepeat()
                }, function(t) {
                    e.error(t)
                })
            }
            var r = t("../utils"),
                o = t("./GenericWorker"),
                s = 16384;
            r.inherits(i, o), i.prototype.cleanUp = function() {
                o.prototype.cleanUp.call(this), this.data = null
            }, i.prototype.resume = function() {
                return !!o.prototype.resume.call(this) && (!this._tickScheduled && this.dataIsReady && (this._tickScheduled = !0, r.delay(this._tickAndRepeat, [], this)), !0)
            }, i.prototype._tickAndRepeat = function() {
                this._tickScheduled = !1, this.isPaused || this.isFinished || (this._tick(), this.isFinished || (r.delay(this._tickAndRepeat, [], this), this._tickScheduled = !0))
            }, i.prototype._tick = function() {
                if (this.isPaused || this.isFinished) return !1;
                var t = null,
                    e = Math.min(this.max, this.index + s);
                if (this.index >= this.max) return this.end();
                switch (this.type) {
                    case "string":
                        t = this.data.substring(this.index, e);
                        break;
                    case "uint8array":
                        t = this.data.subarray(this.index, e);
                        break;
                    case "array":
                    case "nodebuffer":
                        t = this.data.slice(this.index, e)
                }
                return this.index = e, this.push({
                    data: t,
                    meta: {
                        percent: this.max ? this.index / this.max * 100 : 0
                    }
                })
            }, e.exports = i
        }, {
            "../utils": 32,
            "./GenericWorker": 28
        }],
        28: [function(t, e, n) {
            "use strict";

            function i(t) {
                this.name = t || "default", this.streamInfo = {}, this.generatedError = null, this.extraStreamInfo = {}, this.isPaused = !0, this.isFinished = !1, this.isLocked = !1, this._listeners = {
                    data: [],
                    end: [],
                    error: []
                }, this.previous = null
            }
            i.prototype = {
                push: function(t) {
                    this.emit("data", t)
                },
                end: function() {
                    if (this.isFinished) return !1;
                    this.flush();
                    try {
                        this.emit("end"), this.cleanUp(), this.isFinished = !0
                    } catch (t) {
                        this.emit("error", t)
                    }
                    return !0
                },
                error: function(t) {
                    return !this.isFinished && (this.isPaused ? this.generatedError = t : (this.isFinished = !0, this.emit("error", t), this.previous && this.previous.error(t), this.cleanUp()), !0)
                },
                on: function(t, e) {
                    return this._listeners[t].push(e), this
                },
                cleanUp: function() {
                    this.streamInfo = this.generatedError = this.extraStreamInfo = null, this._listeners = []
                },
                emit: function(t, e) {
                    if (this._listeners[t])
                        for (var n = 0; n < this._listeners[t].length; n++) this._listeners[t][n].call(this, e)
                },
                pipe: function(t) {
                    return t.registerPrevious(this)
                },
                registerPrevious: function(t) {
                    if (this.isLocked) throw new Error("The stream '" + this + "' has already been used.");
                    this.streamInfo = t.streamInfo, this.mergeStreamInfo(), this.previous = t;
                    var e = this;
                    return t.on("data", function(t) {
                        e.processChunk(t)
                    }), t.on("end", function() {
                        e.end()
                    }), t.on("error", function(t) {
                        e.error(t)
                    }), this
                },
                pause: function() {
                    return !this.isPaused && !this.isFinished && (this.isPaused = !0, this.previous && this.previous.pause(), !0)
                },
                resume: function() {
                    if (!this.isPaused || this.isFinished) return !1;
                    this.isPaused = !1;
                    var t = !1;
                    return this.generatedError && (this.error(this.generatedError), t = !0), this.previous && this.previous.resume(), !t
                },
                flush: function() {},
                processChunk: function(t) {
                    this.push(t)
                },
                withStreamInfo: function(t, e) {
                    return this.extraStreamInfo[t] = e, this.mergeStreamInfo(), this
                },
                mergeStreamInfo: function() {
                    for (var t in this.extraStreamInfo) this.extraStreamInfo.hasOwnProperty(t) && (this.streamInfo[t] = this.extraStreamInfo[t])
                },
                lock: function() {
                    if (this.isLocked) throw new Error("The stream '" + this + "' has already been used.");
                    this.isLocked = !0, this.previous && this.previous.lock()
                },
                toString: function() {
                    var t = "Worker " + this.name;
                    return this.previous ? this.previous + " -> " + t : t
                }
            }, e.exports = i
        }, {}],
        29: [function(t, e, n) {
            "use strict";

            function i(t, e, n) {
                switch (t) {
                    case "blob":
                        return a.newBlob(a.transformTo("arraybuffer", e), n);
                    case "base64":
                        return c.encode(e);
                    default:
                        return a.transformTo(t, e)
                }
            }

            function r(t, e) {
                var n, i = 0,
                    r = null,
                    o = 0;
                for (n = 0; n < e.length; n++) o += e[n].length;
                switch (t) {
                    case "string":
                        return e.join("");
                    case "array":
                        return Array.prototype.concat.apply([], e);
                    case "uint8array":
                        for (r = new Uint8Array(o), n = 0; n < e.length; n++) r.set(e[n], i), i += e[n].length;
                        return r;
                    case "nodebuffer":
                        return Buffer.concat(e);
                    default:
                        throw new Error("concat : unsupported type '" + t + "'")
                }
            }

            function o(t, e) {
                return new d.Promise(function(n, o) {
                    var s = [],
                        a = t._internalType,
                        l = t._outputType,
                        u = t._mimeType;
                    t.on("data", function(t, n) {
                        s.push(t), e && e(n)
                    }).on("error", function(t) {
                        s = [], o(t)
                    }).on("end", function() {
                        try {
                            var t = i(l, r(a, s), u);
                            n(t)
                        } catch (t) {
                            o(t)
                        }
                        s = []
                    }).resume()
                })
            }

            function s(t, e, n) {
                var i = e;
                switch (e) {
                    case "blob":
                    case "arraybuffer":
                        i = "uint8array";
                        break;
                    case "base64":
                        i = "string"
                }
                try {
                    this._internalType = i, this._outputType = e, this._mimeType = n, a.checkSupport(i), this._worker = t.pipe(new l(i)), t.lock()
                } catch (t) {
                    this._worker = new u("error"), this._worker.error(t)
                }
            }
            var a = t("../utils"),
                l = t("./ConvertWorker"),
                u = t("./GenericWorker"),
                c = t("../base64"),
                h = t("../support"),
                d = t("../external"),
                f = null;
            if (h.nodestream) try {
                f = t("../nodejs/NodejsStreamOutputAdapter")
            } catch (t) {}
            s.prototype = {
                accumulate: function(t) {
                    return o(this, t)
                },
                on: function(t, e) {
                    var n = this;
                    return "data" === t ? this._worker.on(t, function(t) {
                        e.call(n, t.data, t.meta)
                    }) : this._worker.on(t, function() {
                        a.delay(e, arguments, n)
                    }), this
                },
                resume: function() {
                    return a.delay(this._worker.resume, [], this._worker), this
                },
                pause: function() {
                    return this._worker.pause(), this
                },
                toNodejsStream: function(t) {
                    if (a.checkSupport("nodestream"), "nodebuffer" !== this._outputType) throw new Error(this._outputType + " is not supported by this method");
                    return new f(this, {
                        objectMode: "nodebuffer" !== this._outputType
                    }, t)
                }
            }, e.exports = s
        }, {
            "../base64": 1,
            "../external": 6,
            "../nodejs/NodejsStreamOutputAdapter": 13,
            "../support": 30,
            "../utils": 32,
            "./ConvertWorker": 24,
            "./GenericWorker": 28
        }],
        30: [function(t, e, n) {
            "use strict";
            if (n.base64 = !0, n.array = !0, n.string = !0, n.arraybuffer = "undefined" != typeof ArrayBuffer && "undefined" != typeof Uint8Array, n.nodebuffer = "undefined" != typeof Buffer, n.uint8array = "undefined" != typeof Uint8Array, "undefined" == typeof ArrayBuffer) n.blob = !1;
            else {
                var i = new ArrayBuffer(0);
                try {
                    n.blob = 0 === new Blob([i], {
                        type: "application/zip"
                    }).size
                } catch (t) {
                    try {
                        var r = window.BlobBuilder || window.WebKitBlobBuilder || window.MozBlobBuilder || window.MSBlobBuilder,
                            o = new r;
                        o.append(i), n.blob = 0 === o.getBlob("application/zip").size
                    } catch (t) {
                        n.blob = !1
                    }
                }
            }
            try {
                n.nodestream = !!t("readable-stream").Readable
            } catch (t) {
                n.nodestream = !1
            }
        }, {
            "readable-stream": 16
        }],
        31: [function(t, e, n) {
            "use strict";

            function i() {
                l.call(this, "utf-8 decode"), this.leftOver = null
            }

            function r() {
                l.call(this, "utf-8 encode")
            }
            for (var o = t("./utils"), s = t("./support"), a = t("./nodejsUtils"), l = t("./stream/GenericWorker"), u = new Array(256), c = 0; c < 256; c++) u[c] = c >= 252 ? 6 : c >= 248 ? 5 : c >= 240 ? 4 : c >= 224 ? 3 : c >= 192 ? 2 : 1;
            u[254] = u[254] = 1;
            var h = function(t) {
                    var e, n, i, r, o, a = t.length,
                        l = 0;
                    for (r = 0; r < a; r++) n = t.charCodeAt(r), 55296 == (64512 & n) && r + 1 < a && 56320 == (64512 & (i = t.charCodeAt(r + 1))) && (n = 65536 + (n - 55296 << 10) + (i - 56320), r++), l += n < 128 ? 1 : n < 2048 ? 2 : n < 65536 ? 3 : 4;
                    for (e = s.uint8array ? new Uint8Array(l) : new Array(l), o = 0, r = 0; o < l; r++) n = t.charCodeAt(r), 55296 == (64512 & n) && r + 1 < a && 56320 == (64512 & (i = t.charCodeAt(r + 1))) && (n = 65536 + (n - 55296 << 10) + (i - 56320), r++), n < 128 ? e[o++] = n : n < 2048 ? (e[o++] = 192 | n >>> 6, e[o++] = 128 | 63 & n) : n < 65536 ? (e[o++] = 224 | n >>> 12, e[o++] = 128 | n >>> 6 & 63, e[o++] = 128 | 63 & n) : (e[o++] = 240 | n >>> 18, e[o++] = 128 | n >>> 12 & 63, e[o++] = 128 | n >>> 6 & 63, e[o++] = 128 | 63 & n);
                    return e
                },
                d = function(t, e) {
                    var n;
                    for (e = e || t.length, e > t.length && (e = t.length), n = e - 1; n >= 0 && 128 == (192 & t[n]);) n--;
                    return n < 0 ? e : 0 === n ? e : n + u[t[n]] > e ? n : e
                },
                f = function(t) {
                    var e, n, i, r, s = t.length,
                        a = new Array(2 * s);
                    for (n = 0, e = 0; e < s;)
                        if ((i = t[e++]) < 128) a[n++] = i;
                        else if ((r = u[i]) > 4) a[n++] = 65533, e += r - 1;
                    else {
                        for (i &= 2 === r ? 31 : 3 === r ? 15 : 7; r > 1 && e < s;) i = i << 6 | 63 & t[e++], r--;
                        r > 1 ? a[n++] = 65533 : i < 65536 ? a[n++] = i : (i -= 65536, a[n++] = 55296 | i >> 10 & 1023, a[n++] = 56320 | 1023 & i)
                    }
                    return a.length !== n && (a.subarray ? a = a.subarray(0, n) : a.length = n), o.applyFromCharCode(a)
                };
            n.utf8encode = function(t) {
                return s.nodebuffer ? a.newBuffer(t, "utf-8") : h(t)
            }, n.utf8decode = function(t) {
                return s.nodebuffer ? o.transformTo("nodebuffer", t).toString("utf-8") : (t = o.transformTo(s.uint8array ? "uint8array" : "array", t), f(t))
            }, o.inherits(i, l), i.prototype.processChunk = function(t) {
                var e = o.transformTo(s.uint8array ? "uint8array" : "array", t.data);
                if (this.leftOver && this.leftOver.length) {
                    if (s.uint8array) {
                        var i = e;
                        e = new Uint8Array(i.length + this.leftOver.length), e.set(this.leftOver, 0), e.set(i, this.leftOver.length)
                    } else e = this.leftOver.concat(e);
                    this.leftOver = null
                }
                var r = d(e),
                    a = e;
                r !== e.length && (s.uint8array ? (a = e.subarray(0, r), this.leftOver = e.subarray(r, e.length)) : (a = e.slice(0, r), this.leftOver = e.slice(r, e.length))), this.push({
                    data: n.utf8decode(a),
                    meta: t.meta
                })
            }, i.prototype.flush = function() {
                this.leftOver && this.leftOver.length && (this.push({
                    data: n.utf8decode(this.leftOver),
                    meta: {}
                }), this.leftOver = null)
            }, n.Utf8DecodeWorker = i, o.inherits(r, l), r.prototype.processChunk = function(t) {
                this.push({
                    data: n.utf8encode(t.data),
                    meta: t.meta
                })
            }, n.Utf8EncodeWorker = r
        }, {
            "./nodejsUtils": 14,
            "./stream/GenericWorker": 28,
            "./support": 30,
            "./utils": 32
        }],
        32: [function(t, e, n) {
            "use strict";

            function i(t) {
                var e = null;
                return e = l.uint8array ? new Uint8Array(t.length) : new Array(t.length), o(t, e)
            }

            function r(t) {
                return t
            }

            function o(t, e) {
                for (var n = 0; n < t.length; ++n) e[n] = 255 & t.charCodeAt(n);
                return e
            }

            function s(t) {
                var e = 65536,
                    i = n.getTypeOf(t),
                    r = !0;
                if ("uint8array" === i ? r = f.applyCanBeUsed.uint8array : "nodebuffer" === i && (r = f.applyCanBeUsed.nodebuffer), r)
                    for (; e > 1;) try {
                        return f.stringifyByChunk(t, i, e)
                    } catch (t) {
                        e = Math.floor(e / 2)
                    }
                return f.stringifyByChar(t)
            }

            function a(t, e) {
                for (var n = 0; n < t.length; n++) e[n] = t[n];
                return e
            }
            var l = t("./support"),
                u = t("./base64"),
                c = t("./nodejsUtils"),
                h = t("core-js/library/fn/set-immediate"),
                d = t("./external");
            n.newBlob = function(t, e) {
                n.checkSupport("blob");
                try {
                    return new Blob([t], {
                        type: e
                    })
                } catch (n) {
                    try {
                        var i = window.BlobBuilder || window.WebKitBlobBuilder || window.MozBlobBuilder || window.MSBlobBuilder,
                            r = new i;
                        return r.append(t), r.getBlob(e)
                    } catch (t) {
                        throw new Error("Bug : can't construct the Blob.")
                    }
                }
            };
            var f = {
                stringifyByChunk: function(t, e, n) {
                    var i = [],
                        r = 0,
                        o = t.length;
                    if (o <= n) return String.fromCharCode.apply(null, t);
                    for (; r < o;) "array" === e || "nodebuffer" === e ? i.push(String.fromCharCode.apply(null, t.slice(r, Math.min(r + n, o)))) : i.push(String.fromCharCode.apply(null, t.subarray(r, Math.min(r + n, o)))), r += n;
                    return i.join("")
                },
                stringifyByChar: function(t) {
                    for (var e = "", n = 0; n < t.length; n++) e += String.fromCharCode(t[n]);
                    return e
                },
                applyCanBeUsed: {
                    uint8array: function() {
                        try {
                            return l.uint8array && 1 === String.fromCharCode.apply(null, new Uint8Array(1)).length
                        } catch (t) {
                            return !1
                        }
                    }(),
                    nodebuffer: function() {
                        try {
                            return l.nodebuffer && 1 === String.fromCharCode.apply(null, c.newBuffer(1)).length
                        } catch (t) {
                            return !1
                        }
                    }()
                }
            };
            n.applyFromCharCode = s;
            var p = {};
            p.string = {
                string: r,
                array: function(t) {
                    return o(t, new Array(t.length))
                },
                arraybuffer: function(t) {
                    return p.string.uint8array(t).buffer
                },
                uint8array: function(t) {
                    return o(t, new Uint8Array(t.length))
                },
                nodebuffer: function(t) {
                    return o(t, c.newBuffer(t.length))
                }
            }, p.array = {
                string: s,
                array: r,
                arraybuffer: function(t) {
                    return new Uint8Array(t).buffer
                },
                uint8array: function(t) {
                    return new Uint8Array(t)
                },
                nodebuffer: function(t) {
                    return c.newBuffer(t)
                }
            }, p.arraybuffer = {
                string: function(t) {
                    return s(new Uint8Array(t))
                },
                array: function(t) {
                    return a(new Uint8Array(t), new Array(t.byteLength))
                },
                arraybuffer: r,
                uint8array: function(t) {
                    return new Uint8Array(t)
                },
                nodebuffer: function(t) {
                    return c.newBuffer(new Uint8Array(t))
                }
            }, p.uint8array = {
                string: s,
                array: function(t) {
                    return a(t, new Array(t.length))
                },
                arraybuffer: function(t) {
                    return t.buffer
                },
                uint8array: r,
                nodebuffer: function(t) {
                    return c.newBuffer(t)
                }
            }, p.nodebuffer = {
                string: s,
                array: function(t) {
                    return a(t, new Array(t.length))
                },
                arraybuffer: function(t) {
                    return p.nodebuffer.uint8array(t).buffer
                },
                uint8array: function(t) {
                    return a(t, new Uint8Array(t.length))
                },
                nodebuffer: r
            }, n.transformTo = function(t, e) {
                if (e || (e = ""), !t) return e;
                n.checkSupport(t);
                var i = n.getTypeOf(e);
                return p[i][t](e)
            }, n.getTypeOf = function(t) {
                return "string" == typeof t ? "string" : "[object Array]" === Object.prototype.toString.call(t) ? "array" : l.nodebuffer && c.isBuffer(t) ? "nodebuffer" : l.uint8array && t instanceof Uint8Array ? "uint8array" : l.arraybuffer && t instanceof ArrayBuffer ? "arraybuffer" : void 0
            }, n.checkSupport = function(t) {
                if (!l[t.toLowerCase()]) throw new Error(t + " is not supported by this platform")
            }, n.MAX_VALUE_16BITS = 65535, n.MAX_VALUE_32BITS = -1, n.pretty = function(t) {
                var e, n, i = "";
                for (n = 0; n < (t || "").length; n++) e = t.charCodeAt(n), i += "\\x" + (e < 16 ? "0" : "") + e.toString(16).toUpperCase();
                return i
            }, n.delay = function(t, e, n) {
                h(function() {
                    t.apply(n || null, e || [])
                })
            }, n.inherits = function(t, e) {
                var n = function() {};
                n.prototype = e.prototype, t.prototype = new n
            }, n.extend = function() {
                var t, e, n = {};
                for (t = 0; t < arguments.length; t++)
                    for (e in arguments[t]) arguments[t].hasOwnProperty(e) && void 0 === n[e] && (n[e] = arguments[t][e]);
                return n
            }, n.prepareContent = function(t, e, r, o, s) {
                return d.Promise.resolve(e).then(function(t) {
                    return l.blob && t instanceof Blob && "undefined" != typeof FileReader ? new d.Promise(function(e, n) {
                        var i = new FileReader;
                        i.onload = function(t) {
                            e(t.target.result)
                        }, i.onerror = function(t) {
                            n(t.target.error)
                        }, i.readAsArrayBuffer(t)
                    }) : t
                }).then(function(e) {
                    var a = n.getTypeOf(e);
                    return a ? ("arraybuffer" === a ? e = n.transformTo("uint8array", e) : "string" === a && (s ? e = u.decode(e) : r && !0 !== o && (e = i(e))), e) : d.Promise.reject(new Error("The data of '" + t + "' is in an unsupported format !"))
                })
            }
        }, {
            "./base64": 1,
            "./external": 6,
            "./nodejsUtils": 14,
            "./support": 30,
            "core-js/library/fn/set-immediate": 36
        }],
        33: [function(t, e, n) {
            "use strict";

            function i(t) {
                this.files = [],
                    this.loadOptions = t
            }
            var r = t("./reader/readerFor"),
                o = t("./utils"),
                s = t("./signature"),
                a = t("./zipEntry"),
                l = (t("./utf8"), t("./support"));
            i.prototype = {
                checkSignature: function(t) {
                    if (!this.reader.readAndCheckSignature(t)) {
                        this.reader.index -= 4;
                        var e = this.reader.readString(4);
                        throw new Error("Corrupted zip or bug : unexpected signature (" + o.pretty(e) + ", expected " + o.pretty(t) + ")")
                    }
                },
                isSignature: function(t, e) {
                    var n = this.reader.index;
                    this.reader.setIndex(t);
                    var i = this.reader.readString(4),
                        r = i === e;
                    return this.reader.setIndex(n), r
                },
                readBlockEndOfCentral: function() {
                    this.diskNumber = this.reader.readInt(2), this.diskWithCentralDirStart = this.reader.readInt(2), this.centralDirRecordsOnThisDisk = this.reader.readInt(2), this.centralDirRecords = this.reader.readInt(2), this.centralDirSize = this.reader.readInt(4), this.centralDirOffset = this.reader.readInt(4), this.zipCommentLength = this.reader.readInt(2);
                    var t = this.reader.readData(this.zipCommentLength),
                        e = l.uint8array ? "uint8array" : "array",
                        n = o.transformTo(e, t);
                    this.zipComment = this.loadOptions.decodeFileName(n)
                },
                readBlockZip64EndOfCentral: function() {
                    this.zip64EndOfCentralSize = this.reader.readInt(8), this.reader.skip(4), this.diskNumber = this.reader.readInt(4), this.diskWithCentralDirStart = this.reader.readInt(4), this.centralDirRecordsOnThisDisk = this.reader.readInt(8), this.centralDirRecords = this.reader.readInt(8), this.centralDirSize = this.reader.readInt(8), this.centralDirOffset = this.reader.readInt(8), this.zip64ExtensibleData = {};
                    for (var t, e, n, i = this.zip64EndOfCentralSize - 44; 0 < i;) t = this.reader.readInt(2), e = this.reader.readInt(4), n = this.reader.readData(e), this.zip64ExtensibleData[t] = {
                        id: t,
                        length: e,
                        value: n
                    }
                },
                readBlockZip64EndOfCentralLocator: function() {
                    if (this.diskWithZip64CentralDirStart = this.reader.readInt(4), this.relativeOffsetEndOfZip64CentralDir = this.reader.readInt(8), this.disksCount = this.reader.readInt(4), this.disksCount > 1) throw new Error("Multi-volumes zip are not supported")
                },
                readLocalFiles: function() {
                    var t, e;
                    for (t = 0; t < this.files.length; t++) e = this.files[t], this.reader.setIndex(e.localHeaderOffset), this.checkSignature(s.LOCAL_FILE_HEADER), e.readLocalPart(this.reader), e.handleUTF8(), e.processAttributes()
                },
                readCentralDir: function() {
                    var t;
                    for (this.reader.setIndex(this.centralDirOffset); this.reader.readAndCheckSignature(s.CENTRAL_FILE_HEADER);) t = new a({
                        zip64: this.zip64
                    }, this.loadOptions), t.readCentralPart(this.reader), this.files.push(t);
                    if (this.centralDirRecords !== this.files.length && 0 !== this.centralDirRecords && 0 === this.files.length) throw new Error("Corrupted zip or bug: expected " + this.centralDirRecords + " records in central dir, got " + this.files.length)
                },
                readEndOfCentral: function() {
                    var t = this.reader.lastIndexOfSignature(s.CENTRAL_DIRECTORY_END);
                    if (t < 0) {
                        throw !this.isSignature(0, s.LOCAL_FILE_HEADER) ? new Error("Can't find end of central directory : is this a zip file ? If it is, see http://stuk.github.io/jszip/documentation/howto/read_zip.html") : new Error("Corrupted zip : can't find end of central directory")
                    }
                    this.reader.setIndex(t);
                    var e = t;
                    if (this.checkSignature(s.CENTRAL_DIRECTORY_END), this.readBlockEndOfCentral(), this.diskNumber === o.MAX_VALUE_16BITS || this.diskWithCentralDirStart === o.MAX_VALUE_16BITS || this.centralDirRecordsOnThisDisk === o.MAX_VALUE_16BITS || this.centralDirRecords === o.MAX_VALUE_16BITS || this.centralDirSize === o.MAX_VALUE_32BITS || this.centralDirOffset === o.MAX_VALUE_32BITS) {
                        if (this.zip64 = !0, (t = this.reader.lastIndexOfSignature(s.ZIP64_CENTRAL_DIRECTORY_LOCATOR)) < 0) throw new Error("Corrupted zip : can't find the ZIP64 end of central directory locator");
                        if (this.reader.setIndex(t), this.checkSignature(s.ZIP64_CENTRAL_DIRECTORY_LOCATOR), this.readBlockZip64EndOfCentralLocator(), !this.isSignature(this.relativeOffsetEndOfZip64CentralDir, s.ZIP64_CENTRAL_DIRECTORY_END) && (this.relativeOffsetEndOfZip64CentralDir = this.reader.lastIndexOfSignature(s.ZIP64_CENTRAL_DIRECTORY_END), this.relativeOffsetEndOfZip64CentralDir < 0)) throw new Error("Corrupted zip : can't find the ZIP64 end of central directory");
                        this.reader.setIndex(this.relativeOffsetEndOfZip64CentralDir), this.checkSignature(s.ZIP64_CENTRAL_DIRECTORY_END), this.readBlockZip64EndOfCentral()
                    }
                    var n = this.centralDirOffset + this.centralDirSize;
                    this.zip64 && (n += 20, n += 12 + this.zip64EndOfCentralSize);
                    var i = e - n;
                    if (i > 0) this.isSignature(e, s.CENTRAL_FILE_HEADER) || (this.reader.zero = i);
                    else if (i < 0) throw new Error("Corrupted zip: missing " + Math.abs(i) + " bytes.")
                },
                prepareReader: function(t) {
                    this.reader = r(t)
                },
                load: function(t) {
                    this.prepareReader(t), this.readEndOfCentral(), this.readCentralDir(), this.readLocalFiles()
                }
            }, e.exports = i
        }, {
            "./reader/readerFor": 22,
            "./signature": 23,
            "./support": 30,
            "./utf8": 31,
            "./utils": 32,
            "./zipEntry": 34
        }],
        34: [function(t, e, n) {
            "use strict";

            function i(t, e) {
                this.options = t, this.loadOptions = e
            }
            var r = t("./reader/readerFor"),
                o = t("./utils"),
                s = t("./compressedObject"),
                a = t("./crc32"),
                l = t("./utf8"),
                u = t("./compressions"),
                c = t("./support"),
                h = function(t) {
                    for (var e in u)
                        if (u.hasOwnProperty(e) && u[e].magic === t) return u[e];
                    return null
                };
            i.prototype = {
                isEncrypted: function() {
                    return 1 == (1 & this.bitFlag)
                },
                useUTF8: function() {
                    return 2048 == (2048 & this.bitFlag)
                },
                readLocalPart: function(t) {
                    var e, n;
                    if (t.skip(22), this.fileNameLength = t.readInt(2), n = t.readInt(2), this.fileName = t.readData(this.fileNameLength), t.skip(n), -1 === this.compressedSize || -1 === this.uncompressedSize) throw new Error("Bug or corrupted zip : didn't get enough informations from the central directory (compressedSize === -1 || uncompressedSize === -1)");
                    if (null === (e = h(this.compressionMethod))) throw new Error("Corrupted zip : compression " + o.pretty(this.compressionMethod) + " unknown (inner file : " + o.transformTo("string", this.fileName) + ")");
                    this.decompressed = new s(this.compressedSize, this.uncompressedSize, this.crc32, e, t.readData(this.compressedSize))
                },
                readCentralPart: function(t) {
                    this.versionMadeBy = t.readInt(2), t.skip(2), this.bitFlag = t.readInt(2), this.compressionMethod = t.readString(2), this.date = t.readDate(), this.crc32 = t.readInt(4), this.compressedSize = t.readInt(4), this.uncompressedSize = t.readInt(4);
                    var e = t.readInt(2);
                    if (this.extraFieldsLength = t.readInt(2), this.fileCommentLength = t.readInt(2), this.diskNumberStart = t.readInt(2), this.internalFileAttributes = t.readInt(2), this.externalFileAttributes = t.readInt(4), this.localHeaderOffset = t.readInt(4), this.isEncrypted()) throw new Error("Encrypted zip are not supported");
                    t.skip(e), this.readExtraFields(t), this.parseZIP64ExtraField(t), this.fileComment = t.readData(this.fileCommentLength)
                },
                processAttributes: function() {
                    this.unixPermissions = null, this.dosPermissions = null;
                    var t = this.versionMadeBy >> 8;
                    this.dir = !!(16 & this.externalFileAttributes), 0 === t && (this.dosPermissions = 63 & this.externalFileAttributes), 3 === t && (this.unixPermissions = this.externalFileAttributes >> 16 & 65535), this.dir || "/" !== this.fileNameStr.slice(-1) || (this.dir = !0)
                },
                parseZIP64ExtraField: function(t) {
                    if (this.extraFields[1]) {
                        var e = r(this.extraFields[1].value);
                        this.uncompressedSize === o.MAX_VALUE_32BITS && (this.uncompressedSize = e.readInt(8)), this.compressedSize === o.MAX_VALUE_32BITS && (this.compressedSize = e.readInt(8)), this.localHeaderOffset === o.MAX_VALUE_32BITS && (this.localHeaderOffset = e.readInt(8)), this.diskNumberStart === o.MAX_VALUE_32BITS && (this.diskNumberStart = e.readInt(4))
                    }
                },
                readExtraFields: function(t) {
                    var e, n, i, r = t.index + this.extraFieldsLength;
                    for (this.extraFields || (this.extraFields = {}); t.index < r;) e = t.readInt(2), n = t.readInt(2), i = t.readData(n), this.extraFields[e] = {
                        id: e,
                        length: n,
                        value: i
                    }
                },
                handleUTF8: function() {
                    var t = c.uint8array ? "uint8array" : "array";
                    if (this.useUTF8()) this.fileNameStr = l.utf8decode(this.fileName), this.fileCommentStr = l.utf8decode(this.fileComment);
                    else {
                        var e = this.findExtraFieldUnicodePath();
                        if (null !== e) this.fileNameStr = e;
                        else {
                            var n = o.transformTo(t, this.fileName);
                            this.fileNameStr = this.loadOptions.decodeFileName(n)
                        }
                        var i = this.findExtraFieldUnicodeComment();
                        if (null !== i) this.fileCommentStr = i;
                        else {
                            var r = o.transformTo(t, this.fileComment);
                            this.fileCommentStr = this.loadOptions.decodeFileName(r)
                        }
                    }
                },
                findExtraFieldUnicodePath: function() {
                    var t = this.extraFields[28789];
                    if (t) {
                        var e = r(t.value);
                        return 1 !== e.readInt(1) ? null : a(this.fileName) !== e.readInt(4) ? null : l.utf8decode(e.readData(t.length - 5))
                    }
                    return null
                },
                findExtraFieldUnicodeComment: function() {
                    var t = this.extraFields[25461];
                    if (t) {
                        var e = r(t.value);
                        return 1 !== e.readInt(1) ? null : a(this.fileComment) !== e.readInt(4) ? null : l.utf8decode(e.readData(t.length - 5))
                    }
                    return null
                }
            }, e.exports = i
        }, {
            "./compressedObject": 2,
            "./compressions": 3,
            "./crc32": 4,
            "./reader/readerFor": 22,
            "./support": 30,
            "./utf8": 31,
            "./utils": 32
        }],
        35: [function(t, e, n) {
            "use strict";
            var i = t("./stream/StreamHelper"),
                r = t("./stream/DataWorker"),
                o = t("./utf8"),
                s = t("./compressedObject"),
                a = t("./stream/GenericWorker"),
                l = function(t, e, n) {
                    this.name = t, this.dir = n.dir, this.date = n.date, this.comment = n.comment, this.unixPermissions = n.unixPermissions, this.dosPermissions = n.dosPermissions, this._data = e, this._dataBinary = n.binary, this.options = {
                        compression: n.compression,
                        compressionOptions: n.compressionOptions
                    }
                };
            l.prototype = {
                internalStream: function(t) {
                    var e = t.toLowerCase(),
                        n = "string" === e || "text" === e;
                    "binarystring" !== e && "text" !== e || (e = "string");
                    var r = this._decompressWorker(),
                        s = !this._dataBinary;
                    return s && !n && (r = r.pipe(new o.Utf8EncodeWorker)), !s && n && (r = r.pipe(new o.Utf8DecodeWorker)), new i(r, e, "")
                },
                async: function(t, e) {
                    return this.internalStream(t).accumulate(e)
                },
                nodeStream: function(t, e) {
                    return this.internalStream(t || "nodebuffer").toNodejsStream(e)
                },
                _compressWorker: function(t, e) {
                    if (this._data instanceof s && this._data.compression.magic === t.magic) return this._data.getCompressedWorker();
                    var n = this._decompressWorker();
                    return this._dataBinary || (n = n.pipe(new o.Utf8EncodeWorker)), s.createWorkerFrom(n, t, e)
                },
                _decompressWorker: function() {
                    return this._data instanceof s ? this._data.getContentWorker() : this._data instanceof a ? this._data : new r(this._data)
                }
            };
            for (var u = ["asText", "asBinary", "asNodeBuffer", "asUint8Array", "asArrayBuffer"], c = function() {
                    throw new Error("This method has been removed in JSZip 3.0, please check the upgrade guide.")
                }, h = 0; h < u.length; h++) l.prototype[u[h]] = c;
            e.exports = l
        }, {
            "./compressedObject": 2,
            "./stream/DataWorker": 27,
            "./stream/GenericWorker": 28,
            "./stream/StreamHelper": 29,
            "./utf8": 31
        }],
        36: [function(t, e, n) {
            t("../modules/web.immediate"), e.exports = t("../modules/_core").setImmediate
        }, {
            "../modules/_core": 40,
            "../modules/web.immediate": 56
        }],
        37: [function(t, e, n) {
            e.exports = function(t) {
                if ("function" != typeof t) throw TypeError(t + " is not a function!");
                return t
            }
        }, {}],
        38: [function(t, e, n) {
            var i = t("./_is-object");
            e.exports = function(t) {
                if (!i(t)) throw TypeError(t + " is not an object!");
                return t
            }
        }, {
            "./_is-object": 51
        }],
        39: [function(t, e, n) {
            var i = {}.toString;
            e.exports = function(t) {
                return i.call(t).slice(8, -1)
            }
        }, {}],
        40: [function(t, e, n) {
            var i = e.exports = {
                version: "2.3.0"
            };
            "number" == typeof __e && (__e = i)
        }, {}],
        41: [function(t, e, n) {
            var i = t("./_a-function");
            e.exports = function(t, e, n) {
                if (i(t), void 0 === e) return t;
                switch (n) {
                    case 1:
                        return function(n) {
                            return t.call(e, n)
                        };
                    case 2:
                        return function(n, i) {
                            return t.call(e, n, i)
                        };
                    case 3:
                        return function(n, i, r) {
                            return t.call(e, n, i, r)
                        }
                }
                return function() {
                    return t.apply(e, arguments)
                }
            }
        }, {
            "./_a-function": 37
        }],
        42: [function(t, e, n) {
            e.exports = !t("./_fails")(function() {
                return 7 != Object.defineProperty({}, "a", {
                    get: function() {
                        return 7
                    }
                }).a
            })
        }, {
            "./_fails": 45
        }],
        43: [function(t, e, n) {
            var i = t("./_is-object"),
                r = t("./_global").document,
                o = i(r) && i(r.createElement);
            e.exports = function(t) {
                return o ? r.createElement(t) : {}
            }
        }, {
            "./_global": 46,
            "./_is-object": 51
        }],
        44: [function(t, e, n) {
            var i = t("./_global"),
                r = t("./_core"),
                o = t("./_ctx"),
                s = t("./_hide"),
                a = "prototype",
                l = function(t, e, n) {
                    var u, c, h, d = t & l.F,
                        f = t & l.G,
                        p = t & l.S,
                        m = t & l.P,
                        g = t & l.B,
                        v = t & l.W,
                        y = f ? r : r[e] || (r[e] = {}),
                        b = y[a],
                        _ = f ? i : p ? i[e] : (i[e] || {})[a];
                    f && (n = e);
                    for (u in n)(c = !d && _ && void 0 !== _[u]) && u in y || (h = c ? _[u] : n[u], y[u] = f && "function" != typeof _[u] ? n[u] : g && c ? o(h, i) : v && _[u] == h ? function(t) {
                        var e = function(e, n, i) {
                            if (this instanceof t) {
                                switch (arguments.length) {
                                    case 0:
                                        return new t;
                                    case 1:
                                        return new t(e);
                                    case 2:
                                        return new t(e, n)
                                }
                                return new t(e, n, i)
                            }
                            return t.apply(this, arguments)
                        };
                        return e[a] = t[a], e
                    }(h) : m && "function" == typeof h ? o(Function.call, h) : h, m && ((y.virtual || (y.virtual = {}))[u] = h, t & l.R && b && !b[u] && s(b, u, h)))
                };
            l.F = 1, l.G = 2, l.S = 4, l.P = 8, l.B = 16, l.W = 32, l.U = 64, l.R = 128, e.exports = l
        }, {
            "./_core": 40,
            "./_ctx": 41,
            "./_global": 46,
            "./_hide": 47
        }],
        45: [function(t, e, n) {
            e.exports = function(t) {
                try {
                    return !!t()
                } catch (t) {
                    return !0
                }
            }
        }, {}],
        46: [function(t, e, n) {
            var i = e.exports = "undefined" != typeof window && window.Math == Math ? window : "undefined" != typeof self && self.Math == Math ? self : Function("return this")();
            "number" == typeof __g && (__g = i)
        }, {}],
        47: [function(t, e, n) {
            var i = t("./_object-dp"),
                r = t("./_property-desc");
            e.exports = t("./_descriptors") ? function(t, e, n) {
                return i.f(t, e, r(1, n))
            } : function(t, e, n) {
                return t[e] = n, t
            }
        }, {
            "./_descriptors": 42,
            "./_object-dp": 52,
            "./_property-desc": 53
        }],
        48: [function(t, e, n) {
            e.exports = t("./_global").document && document.documentElement
        }, {
            "./_global": 46
        }],
        49: [function(t, e, n) {
            e.exports = !t("./_descriptors") && !t("./_fails")(function() {
                return 7 != Object.defineProperty(t("./_dom-create")("div"), "a", {
                    get: function() {
                        return 7
                    }
                }).a
            })
        }, {
            "./_descriptors": 42,
            "./_dom-create": 43,
            "./_fails": 45
        }],
        50: [function(t, e, n) {
            e.exports = function(t, e, n) {
                var i = void 0 === n;
                switch (e.length) {
                    case 0:
                        return i ? t() : t.call(n);
                    case 1:
                        return i ? t(e[0]) : t.call(n, e[0]);
                    case 2:
                        return i ? t(e[0], e[1]) : t.call(n, e[0], e[1]);
                    case 3:
                        return i ? t(e[0], e[1], e[2]) : t.call(n, e[0], e[1], e[2]);
                    case 4:
                        return i ? t(e[0], e[1], e[2], e[3]) : t.call(n, e[0], e[1], e[2], e[3])
                }
                return t.apply(n, e)
            }
        }, {}],
        51: [function(t, e, n) {
            e.exports = function(t) {
                return "object" == typeof t ? null !== t : "function" == typeof t
            }
        }, {}],
        52: [function(t, e, n) {
            var i = t("./_an-object"),
                r = t("./_ie8-dom-define"),
                o = t("./_to-primitive"),
                s = Object.defineProperty;
            n.f = t("./_descriptors") ? Object.defineProperty : function(t, e, n) {
                if (i(t), e = o(e, !0), i(n), r) try {
                    return s(t, e, n)
                } catch (t) {}
                if ("get" in n || "set" in n) throw TypeError("Accessors not supported!");
                return "value" in n && (t[e] = n.value), t
            }
        }, {
            "./_an-object": 38,
            "./_descriptors": 42,
            "./_ie8-dom-define": 49,
            "./_to-primitive": 55
        }],
        53: [function(t, e, n) {
            e.exports = function(t, e) {
                return {
                    enumerable: !(1 & t),
                    configurable: !(2 & t),
                    writable: !(4 & t),
                    value: e
                }
            }
        }, {}],
        54: [function(t, e, n) {
            var i, r, o, s = t("./_ctx"),
                a = t("./_invoke"),
                l = t("./_html"),
                u = t("./_dom-create"),
                c = t("./_global"),
                h = c.process,
                d = c.setImmediate,
                f = c.clearImmediate,
                p = c.MessageChannel,
                m = 0,
                g = {},
                v = "onreadystatechange",
                y = function() {
                    var t = +this;
                    if (g.hasOwnProperty(t)) {
                        var e = g[t];
                        delete g[t], e()
                    }
                },
                b = function(t) {
                    y.call(t.data)
                };
            d && f || (d = function(t) {
                for (var e = [], n = 1; arguments.length > n;) e.push(arguments[n++]);
                return g[++m] = function() {
                    a("function" == typeof t ? t : Function(t), e)
                }, i(m), m
            }, f = function(t) {
                delete g[t]
            }, "process" == t("./_cof")(h) ? i = function(t) {
                h.nextTick(s(y, t, 1))
            } : p ? (r = new p, o = r.port2, r.port1.onmessage = b, i = s(o.postMessage, o, 1)) : c.addEventListener && "function" == typeof postMessage && !c.importScripts ? (i = function(t) {
                c.postMessage(t + "", "*")
            }, c.addEventListener("message", b, !1)) : i = v in u("script") ? function(t) {
                l.appendChild(u("script"))[v] = function() {
                    l.removeChild(this), y.call(t)
                }
            } : function(t) {
                setTimeout(s(y, t, 1), 0)
            }), e.exports = {
                set: d,
                clear: f
            }
        }, {
            "./_cof": 39,
            "./_ctx": 41,
            "./_dom-create": 43,
            "./_global": 46,
            "./_html": 48,
            "./_invoke": 50
        }],
        55: [function(t, e, n) {
            var i = t("./_is-object");
            e.exports = function(t, e) {
                if (!i(t)) return t;
                var n, r;
                if (e && "function" == typeof(n = t.toString) && !i(r = n.call(t))) return r;
                if ("function" == typeof(n = t.valueOf) && !i(r = n.call(t))) return r;
                if (!e && "function" == typeof(n = t.toString) && !i(r = n.call(t))) return r;
                throw TypeError("Can't convert object to primitive value")
            }
        }, {
            "./_is-object": 51
        }],
        56: [function(t, e, n) {
            var i = t("./_export"),
                r = t("./_task");
            i(i.G + i.B, {
                setImmediate: r.set,
                clearImmediate: r.clear
            })
        }, {
            "./_export": 44,
            "./_task": 54
        }],
        57: [function(t, e, n) {
            (function(t) {
                "use strict";

                function n() {
                    c = !0;
                    for (var t, e, n = h.length; n;) {
                        for (e = h, h = [], t = -1; ++t < n;) e[t]();
                        n = h.length
                    }
                    c = !1
                }

                function i(t) {
                    1 !== h.push(t) || c || r()
                }
                var r, o = t.MutationObserver || t.WebKitMutationObserver;
                if (o) {
                    var s = 0,
                        a = new o(n),
                        l = t.document.createTextNode("");
                    a.observe(l, {
                        characterData: !0
                    }), r = function() {
                        l.data = s = ++s % 2
                    }
                } else if (t.setImmediate || void 0 === t.MessageChannel) r = "document" in t && "onreadystatechange" in t.document.createElement("script") ? function() {
                    var e = t.document.createElement("script");
                    e.onreadystatechange = function() {
                        n(), e.onreadystatechange = null, e.parentNode.removeChild(e), e = null
                    }, t.document.documentElement.appendChild(e)
                } : function() {
                    setTimeout(n, 0)
                };
                else {
                    var u = new t.MessageChannel;
                    u.port1.onmessage = n, r = function() {
                        u.port2.postMessage(0)
                    }
                }
                var c, h = [];
                e.exports = i
            }).call(this, "undefined" != typeof global ? global : "undefined" != typeof self ? self : "undefined" != typeof window ? window : {})
        }, {}],
        58: [function(t, e, n) {
            "use strict";

            function i() {}

            function r(t) {
                if ("function" != typeof t) throw new TypeError("resolver must be a function");
                this.state = y, this.queue = [], this.outcome = void 0, t !== i && l(this, t)
            }

            function o(t, e, n) {
                this.promise = t, "function" == typeof e && (this.onFulfilled = e, this.callFulfilled = this.otherCallFulfilled), "function" == typeof n && (this.onRejected = n, this.callRejected = this.otherCallRejected)
            }

            function s(t, e, n) {
                p(function() {
                    var i;
                    try {
                        i = e(n)
                    } catch (e) {
                        return m.reject(t, e)
                    }
                    i === t ? m.reject(t, new TypeError("Cannot resolve promise with itself")) : m.resolve(t, i)
                })
            }

            function a(t) {
                var e = t && t.then;
                if (t && "object" == typeof t && "function" == typeof e) return function() {
                    e.apply(t, arguments)
                }
            }

            function l(t, e) {
                function n(e) {
                    o || (o = !0, m.reject(t, e))
                }

                function i(e) {
                    o || (o = !0, m.resolve(t, e))
                }

                function r() {
                    e(i, n)
                }
                var o = !1,
                    s = u(r);
                "error" === s.status && n(s.value)
            }

            function u(t, e) {
                var n = {};
                try {
                    n.value = t(e), n.status = "success"
                } catch (t) {
                    n.status = "error", n.value = t
                }
                return n
            }

            function c(t) {
                return t instanceof this ? t : m.resolve(new this(i), t)
            }

            function h(t) {
                var e = new this(i);
                return m.reject(e, t)
            }

            function d(t) {
                var e = this;
                if ("[object Array]" !== Object.prototype.toString.call(t)) return this.reject(new TypeError("must be an array"));
                var n = t.length,
                    r = !1;
                if (!n) return this.resolve([]);
                for (var o = new Array(n), s = 0, a = -1, l = new this(i); ++a < n;) ! function(t, i) {
                    function a(t) {
                        o[i] = t, ++s !== n || r || (r = !0, m.resolve(l, o))
                    }
                    e.resolve(t).then(a, function(t) {
                        r || (r = !0, m.reject(l, t))
                    })
                }(t[a], a);
                return l
            }

            function f(t) {
                var e = this;
                if ("[object Array]" !== Object.prototype.toString.call(t)) return this.reject(new TypeError("must be an array"));
                var n = t.length,
                    r = !1;
                if (!n) return this.resolve([]);
                for (var o = -1, s = new this(i); ++o < n;) ! function(t) {
                    e.resolve(t).then(function(t) {
                        r || (r = !0, m.resolve(s, t))
                    }, function(t) {
                        r || (r = !0, m.reject(s, t))
                    })
                }(t[o]);
                return s
            }
            var p = t("immediate"),
                m = {},
                g = ["REJECTED"],
                v = ["FULFILLED"],
                y = ["PENDING"];
            e.exports = r, r.prototype.catch = function(t) {
                return this.then(null, t)
            }, r.prototype.then = function(t, e) {
                if ("function" != typeof t && this.state === v || "function" != typeof e && this.state === g) return this;
                var n = new this.constructor(i);
                if (this.state !== y) {
                    s(n, this.state === v ? t : e, this.outcome)
                } else this.queue.push(new o(n, t, e));
                return n
            }, o.prototype.callFulfilled = function(t) {
                m.resolve(this.promise, t)
            }, o.prototype.otherCallFulfilled = function(t) {
                s(this.promise, this.onFulfilled, t)
            }, o.prototype.callRejected = function(t) {
                m.reject(this.promise, t)
            }, o.prototype.otherCallRejected = function(t) {
                s(this.promise, this.onRejected, t)
            }, m.resolve = function(t, e) {
                var n = u(a, e);
                if ("error" === n.status) return m.reject(t, n.value);
                var i = n.value;
                if (i) l(t, i);
                else {
                    t.state = v, t.outcome = e;
                    for (var r = -1, o = t.queue.length; ++r < o;) t.queue[r].callFulfilled(e)
                }
                return t
            }, m.reject = function(t, e) {
                t.state = g, t.outcome = e;
                for (var n = -1, i = t.queue.length; ++n < i;) t.queue[n].callRejected(e);
                return t
            }, r.resolve = c, r.reject = h, r.all = d, r.race = f
        }, {
            immediate: 57
        }],
        59: [function(t, e, n) {
            "use strict";
            var i = t("./lib/utils/common").assign,
                r = t("./lib/deflate"),
                o = t("./lib/inflate"),
                s = t("./lib/zlib/constants"),
                a = {};
            i(a, r, o, s), e.exports = a
        }, {
            "./lib/deflate": 60,
            "./lib/inflate": 61,
            "./lib/utils/common": 62,
            "./lib/zlib/constants": 65
        }],
        60: [function(t, e, n) {
            "use strict";

            function i(t) {
                if (!(this instanceof i)) return new i(t);
                this.options = l.assign({
                    level: p,
                    method: g,
                    chunkSize: 16384,
                    windowBits: 15,
                    memLevel: 8,
                    strategy: m,
                    to: ""
                }, t || {});
                var e = this.options;
                e.raw && e.windowBits > 0 ? e.windowBits = -e.windowBits : e.gzip && e.windowBits > 0 && e.windowBits < 16 && (e.windowBits += 16), this.err = 0, this.msg = "", this.ended = !1, this.chunks = [], this.strm = new h, this.strm.avail_out = 0;
                var n = a.deflateInit2(this.strm, e.level, e.method, e.windowBits, e.memLevel, e.strategy);
                if (n !== f) throw new Error(c[n]);
                if (e.header && a.deflateSetHeader(this.strm, e.header), e.dictionary) {
                    var r;
                    if (r = "string" == typeof e.dictionary ? u.string2buf(e.dictionary) : "[object ArrayBuffer]" === d.call(e.dictionary) ? new Uint8Array(e.dictionary) : e.dictionary, (n = a.deflateSetDictionary(this.strm, r)) !== f) throw new Error(c[n]);
                    this._dict_set = !0
                }
            }

            function r(t, e) {
                var n = new i(e);
                if (n.push(t, !0), n.err) throw n.msg;
                return n.result
            }

            function o(t, e) {
                return e = e || {}, e.raw = !0, r(t, e)
            }

            function s(t, e) {
                return e = e || {}, e.gzip = !0, r(t, e)
            }
            var a = t("./zlib/deflate"),
                l = t("./utils/common"),
                u = t("./utils/strings"),
                c = t("./zlib/messages"),
                h = t("./zlib/zstream"),
                d = Object.prototype.toString,
                f = 0,
                p = -1,
                m = 0,
                g = 8;
            i.prototype.push = function(t, e) {
                var n, i, r = this.strm,
                    o = this.options.chunkSize;
                if (this.ended) return !1;
                i = e === ~~e ? e : !0 === e ? 4 : 0, "string" == typeof t ? r.input = u.string2buf(t) : "[object ArrayBuffer]" === d.call(t) ? r.input = new Uint8Array(t) : r.input = t, r.next_in = 0, r.avail_in = r.input.length;
                do {
                    if (0 === r.avail_out && (r.output = new l.Buf8(o), r.next_out = 0, r.avail_out = o), 1 !== (n = a.deflate(r, i)) && n !== f) return this.onEnd(n), this.ended = !0, !1;
                    0 !== r.avail_out && (0 !== r.avail_in || 4 !== i && 2 !== i) || ("string" === this.options.to ? this.onData(u.buf2binstring(l.shrinkBuf(r.output, r.next_out))) : this.onData(l.shrinkBuf(r.output, r.next_out)))
                } while ((r.avail_in > 0 || 0 === r.avail_out) && 1 !== n);
                return 4 === i ? (n = a.deflateEnd(this.strm), this.onEnd(n), this.ended = !0, n === f) : 2 !== i || (this.onEnd(f), r.avail_out = 0, !0)
            }, i.prototype.onData = function(t) {
                this.chunks.push(t)
            }, i.prototype.onEnd = function(t) {
                t === f && ("string" === this.options.to ? this.result = this.chunks.join("") : this.result = l.flattenChunks(this.chunks)), this.chunks = [], this.err = t, this.msg = this.strm.msg
            }, n.Deflate = i, n.deflate = r, n.deflateRaw = o, n.gzip = s
        }, {
            "./utils/common": 62,
            "./utils/strings": 63,
            "./zlib/deflate": 67,
            "./zlib/messages": 72,
            "./zlib/zstream": 74
        }],
        61: [function(t, e, n) {
            "use strict";

            function i(t) {
                if (!(this instanceof i)) return new i(t);
                this.options = a.assign({
                    chunkSize: 16384,
                    windowBits: 0,
                    to: ""
                }, t || {});
                var e = this.options;
                e.raw && e.windowBits >= 0 && e.windowBits < 16 && (e.windowBits = -e.windowBits, 0 === e.windowBits && (e.windowBits = -15)), !(e.windowBits >= 0 && e.windowBits < 16) || t && t.windowBits || (e.windowBits += 32), e.windowBits > 15 && e.windowBits < 48 && 0 == (15 & e.windowBits) && (e.windowBits |= 15), this.err = 0, this.msg = "", this.ended = !1, this.chunks = [], this.strm = new h, this.strm.avail_out = 0;
                var n = s.inflateInit2(this.strm, e.windowBits);
                if (n !== u.Z_OK) throw new Error(c[n]);
                this.header = new d, s.inflateGetHeader(this.strm, this.header)
            }

            function r(t, e) {
                var n = new i(e);
                if (n.push(t, !0), n.err) throw n.msg;
                return n.result
            }

            function o(t, e) {
                return e = e || {}, e.raw = !0, r(t, e)
            }
            var s = t("./zlib/inflate"),
                a = t("./utils/common"),
                l = t("./utils/strings"),
                u = t("./zlib/constants"),
                c = t("./zlib/messages"),
                h = t("./zlib/zstream"),
                d = t("./zlib/gzheader"),
                f = Object.prototype.toString;
            i.prototype.push = function(t, e) {
                var n, i, r, o, c, h, d = this.strm,
                    p = this.options.chunkSize,
                    m = this.options.dictionary,
                    g = !1;
                if (this.ended) return !1;
                i = e === ~~e ? e : !0 === e ? u.Z_FINISH : u.Z_NO_FLUSH, "string" == typeof t ? d.input = l.binstring2buf(t) : "[object ArrayBuffer]" === f.call(t) ? d.input = new Uint8Array(t) : d.input = t, d.next_in = 0, d.avail_in = d.input.length;
                do {
                    if (0 === d.avail_out && (d.output = new a.Buf8(p), d.next_out = 0, d.avail_out = p), n = s.inflate(d, u.Z_NO_FLUSH), n === u.Z_NEED_DICT && m && (h = "string" == typeof m ? l.string2buf(m) : "[object ArrayBuffer]" === f.call(m) ? new Uint8Array(m) : m, n = s.inflateSetDictionary(this.strm, h)), n === u.Z_BUF_ERROR && !0 === g && (n = u.Z_OK, g = !1), n !== u.Z_STREAM_END && n !== u.Z_OK) return this.onEnd(n), this.ended = !0, !1;
                    d.next_out && (0 !== d.avail_out && n !== u.Z_STREAM_END && (0 !== d.avail_in || i !== u.Z_FINISH && i !== u.Z_SYNC_FLUSH) || ("string" === this.options.to ? (r = l.utf8border(d.output, d.next_out), o = d.next_out - r, c = l.buf2string(d.output, r), d.next_out = o, d.avail_out = p - o, o && a.arraySet(d.output, d.output, r, o, 0), this.onData(c)) : this.onData(a.shrinkBuf(d.output, d.next_out)))), 0 === d.avail_in && 0 === d.avail_out && (g = !0)
                } while ((d.avail_in > 0 || 0 === d.avail_out) && n !== u.Z_STREAM_END);
                return n === u.Z_STREAM_END && (i = u.Z_FINISH), i === u.Z_FINISH ? (n = s.inflateEnd(this.strm), this.onEnd(n), this.ended = !0, n === u.Z_OK) : i !== u.Z_SYNC_FLUSH || (this.onEnd(u.Z_OK), d.avail_out = 0, !0)
            }, i.prototype.onData = function(t) {
                this.chunks.push(t)
            }, i.prototype.onEnd = function(t) {
                t === u.Z_OK && ("string" === this.options.to ? this.result = this.chunks.join("") : this.result = a.flattenChunks(this.chunks)), this.chunks = [], this.err = t, this.msg = this.strm.msg
            }, n.Inflate = i, n.inflate = r, n.inflateRaw = o, n.ungzip = r
        }, {
            "./utils/common": 62,
            "./utils/strings": 63,
            "./zlib/constants": 65,
            "./zlib/gzheader": 68,
            "./zlib/inflate": 70,
            "./zlib/messages": 72,
            "./zlib/zstream": 74
        }],
        62: [function(t, e, n) {
            "use strict";
            var i = "undefined" != typeof Uint8Array && "undefined" != typeof Uint16Array && "undefined" != typeof Int32Array;
            n.assign = function(t) {
                for (var e = Array.prototype.slice.call(arguments, 1); e.length;) {
                    var n = e.shift();
                    if (n) {
                        if ("object" != typeof n) throw new TypeError(n + "must be non-object");
                        for (var i in n) n.hasOwnProperty(i) && (t[i] = n[i])
                    }
                }
                return t
            }, n.shrinkBuf = function(t, e) {
                return t.length === e ? t : t.subarray ? t.subarray(0, e) : (t.length = e, t)
            };
            var r = {
                    arraySet: function(t, e, n, i, r) {
                        if (e.subarray && t.subarray) return void t.set(e.subarray(n, n + i), r);
                        for (var o = 0; o < i; o++) t[r + o] = e[n + o]
                    },
                    flattenChunks: function(t) {
                        var e, n, i, r, o, s;
                        for (i = 0, e = 0, n = t.length; e < n; e++) i += t[e].length;
                        for (s = new Uint8Array(i), r = 0, e = 0, n = t.length; e < n; e++) o = t[e], s.set(o, r), r += o.length;
                        return s
                    }
                },
                o = {
                    arraySet: function(t, e, n, i, r) {
                        for (var o = 0; o < i; o++) t[r + o] = e[n + o]
                    },
                    flattenChunks: function(t) {
                        return [].concat.apply([], t)
                    }
                };
            n.setTyped = function(t) {
                t ? (n.Buf8 = Uint8Array, n.Buf16 = Uint16Array, n.Buf32 = Int32Array, n.assign(n, r)) : (n.Buf8 = Array, n.Buf16 = Array, n.Buf32 = Array, n.assign(n, o))
            }, n.setTyped(i)
        }, {}],
        63: [function(t, e, n) {
            "use strict";

            function i(t, e) {
                if (e < 65537 && (t.subarray && s || !t.subarray && o)) return String.fromCharCode.apply(null, r.shrinkBuf(t, e));
                for (var n = "", i = 0; i < e; i++) n += String.fromCharCode(t[i]);
                return n
            }
            var r = t("./common"),
                o = !0,
                s = !0;
            try {
                String.fromCharCode.apply(null, [0])
            } catch (t) {
                o = !1
            }
            try {
                String.fromCharCode.apply(null, new Uint8Array(1))
            } catch (t) {
                s = !1
            }
            for (var a = new r.Buf8(256), l = 0; l < 256; l++) a[l] = l >= 252 ? 6 : l >= 248 ? 5 : l >= 240 ? 4 : l >= 224 ? 3 : l >= 192 ? 2 : 1;
            a[254] = a[254] = 1, n.string2buf = function(t) {
                var e, n, i, o, s, a = t.length,
                    l = 0;
                for (o = 0; o < a; o++) n = t.charCodeAt(o), 55296 == (64512 & n) && o + 1 < a && 56320 == (64512 & (i = t.charCodeAt(o + 1))) && (n = 65536 + (n - 55296 << 10) + (i - 56320), o++), l += n < 128 ? 1 : n < 2048 ? 2 : n < 65536 ? 3 : 4;
                for (e = new r.Buf8(l), s = 0, o = 0; s < l; o++) n = t.charCodeAt(o), 55296 == (64512 & n) && o + 1 < a && 56320 == (64512 & (i = t.charCodeAt(o + 1))) && (n = 65536 + (n - 55296 << 10) + (i - 56320), o++), n < 128 ? e[s++] = n : n < 2048 ? (e[s++] = 192 | n >>> 6, e[s++] = 128 | 63 & n) : n < 65536 ? (e[s++] = 224 | n >>> 12, e[s++] = 128 | n >>> 6 & 63, e[s++] = 128 | 63 & n) : (e[s++] = 240 | n >>> 18, e[s++] = 128 | n >>> 12 & 63, e[s++] = 128 | n >>> 6 & 63, e[s++] = 128 | 63 & n);
                return e
            }, n.buf2binstring = function(t) {
                return i(t, t.length)
            }, n.binstring2buf = function(t) {
                for (var e = new r.Buf8(t.length), n = 0, i = e.length; n < i; n++) e[n] = t.charCodeAt(n);
                return e
            }, n.buf2string = function(t, e) {
                var n, r, o, s, l = e || t.length,
                    u = new Array(2 * l);
                for (r = 0, n = 0; n < l;)
                    if ((o = t[n++]) < 128) u[r++] = o;
                    else if ((s = a[o]) > 4) u[r++] = 65533, n += s - 1;
                else {
                    for (o &= 2 === s ? 31 : 3 === s ? 15 : 7; s > 1 && n < l;) o = o << 6 | 63 & t[n++], s--;
                    s > 1 ? u[r++] = 65533 : o < 65536 ? u[r++] = o : (o -= 65536, u[r++] = 55296 | o >> 10 & 1023, u[r++] = 56320 | 1023 & o)
                }
                return i(u, r)
            }, n.utf8border = function(t, e) {
                var n;
                for (e = e || t.length, e > t.length && (e = t.length), n = e - 1; n >= 0 && 128 == (192 & t[n]);) n--;
                return n < 0 ? e : 0 === n ? e : n + a[t[n]] > e ? n : e
            }
        }, {
            "./common": 62
        }],
        64: [function(t, e, n) {
            "use strict";

            function i(t, e, n, i) {
                for (var r = 65535 & t | 0, o = t >>> 16 & 65535 | 0, s = 0; 0 !== n;) {
                    s = n > 2e3 ? 2e3 : n, n -= s;
                    do {
                        r = r + e[i++] | 0, o = o + r | 0
                    } while (--s);
                    r %= 65521, o %= 65521
                }
                return r | o << 16 | 0
            }
            e.exports = i
        }, {}],
        65: [function(t, e, n) {
            "use strict";
            e.exports = {
                Z_NO_FLUSH: 0,
                Z_PARTIAL_FLUSH: 1,
                Z_SYNC_FLUSH: 2,
                Z_FULL_FLUSH: 3,
                Z_FINISH: 4,
                Z_BLOCK: 5,
                Z_TREES: 6,
                Z_OK: 0,
                Z_STREAM_END: 1,
                Z_NEED_DICT: 2,
                Z_ERRNO: -1,
                Z_STREAM_ERROR: -2,
                Z_DATA_ERROR: -3,
                Z_BUF_ERROR: -5,
                Z_NO_COMPRESSION: 0,
                Z_BEST_SPEED: 1,
                Z_BEST_COMPRESSION: 9,
                Z_DEFAULT_COMPRESSION: -1,
                Z_FILTERED: 1,
                Z_HUFFMAN_ONLY: 2,
                Z_RLE: 3,
                Z_FIXED: 4,
                Z_DEFAULT_STRATEGY: 0,
                Z_BINARY: 0,
                Z_TEXT: 1,
                Z_UNKNOWN: 2,
                Z_DEFLATED: 8
            }
        }, {}],
        66: [function(t, e, n) {
            "use strict";

            function i(t, e, n, i) {
                var o = r,
                    s = i + n;
                t ^= -1;
                for (var a = i; a < s; a++) t = t >>> 8 ^ o[255 & (t ^ e[a])];
                return -1 ^ t
            }
            var r = function() {
                for (var t, e = [], n = 0; n < 256; n++) {
                    t = n;
                    for (var i = 0; i < 8; i++) t = 1 & t ? 3988292384 ^ t >>> 1 : t >>> 1;
                    e[n] = t
                }
                return e
            }();
            e.exports = i
        }, {}],
        67: [function(t, e, n) {
            "use strict";

            function i(t, e) {
                return t.msg = L[e], e
            }

            function r(t) {
                return (t << 1) - (t > 4 ? 9 : 0)
            }

            function o(t) {
                for (var e = t.length; --e >= 0;) t[e] = 0
            }

            function s(t) {
                var e = t.state,
                    n = e.pending;
                n > t.avail_out && (n = t.avail_out), 0 !== n && (D.arraySet(t.output, e.pending_buf, e.pending_out, n, t.next_out), t.next_out += n, e.pending_out += n, t.total_out += n, t.avail_out -= n, e.pending -= n, 0 === e.pending && (e.pending_out = 0))
            }

            function a(t, e) {
                O._tr_flush_block(t, t.block_start >= 0 ? t.block_start : -1, t.strstart - t.block_start, e), t.block_start = t.strstart, s(t.strm)
            }

            function l(t, e) {
                t.pending_buf[t.pending++] = e
            }

            function u(t, e) {
                t.pending_buf[t.pending++] = e >>> 8 & 255, t.pending_buf[t.pending++] = 255 & e
            }

            function c(t, e, n, i) {
                var r = t.avail_in;
                return r > i && (r = i), 0 === r ? 0 : (t.avail_in -= r, D.arraySet(e, t.input, t.next_in, r, n), 1 === t.state.wrap ? t.adler = I(t.adler, e, r, n) : 2 === t.state.wrap && (t.adler = z(t.adler, e, r, n)), t.next_in += r, t.total_in += r, r)
            }

            function h(t, e) {
                var n, i, r = t.max_chain_length,
                    o = t.strstart,
                    s = t.prev_length,
                    a = t.nice_match,
                    l = t.strstart > t.w_size - ut ? t.strstart - (t.w_size - ut) : 0,
                    u = t.window,
                    c = t.w_mask,
                    h = t.prev,
                    d = t.strstart + lt,
                    f = u[o + s - 1],
                    p = u[o + s];
                t.prev_length >= t.good_match && (r >>= 2), a > t.lookahead && (a = t.lookahead);
                do {
                    if (n = e, u[n + s] === p && u[n + s - 1] === f && u[n] === u[o] && u[++n] === u[o + 1]) {
                        o += 2, n++;
                        do {} while (u[++o] === u[++n] && u[++o] === u[++n] && u[++o] === u[++n] && u[++o] === u[++n] && u[++o] === u[++n] && u[++o] === u[++n] && u[++o] === u[++n] && u[++o] === u[++n] && o < d);
                        if (i = lt - (d - o), o = d - lt, i > s) {
                            if (t.match_start = e, s = i, i >= a) break;
                            f = u[o + s - 1], p = u[o + s]
                        }
                    }
                } while ((e = h[e & c]) > l && 0 != --r);
                return s <= t.lookahead ? s : t.lookahead
            }

            function d(t) {
                var e, n, i, r, o, s = t.w_size;
                do {
                    if (r = t.window_size - t.lookahead - t.strstart, t.strstart >= s + (s - ut)) {
                        D.arraySet(t.window, t.window, s, s, 0), t.match_start -= s, t.strstart -= s, t.block_start -= s, n = t.hash_size, e = n;
                        do {
                            i = t.head[--e], t.head[e] = i >= s ? i - s : 0
                        } while (--n);
                        n = s, e = n;
                        do {
                            i = t.prev[--e], t.prev[e] = i >= s ? i - s : 0
                        } while (--n);
                        r += s
                    }
                    if (0 === t.strm.avail_in) break;
                    if (n = c(t.strm, t.window, t.strstart + t.lookahead, r), t.lookahead += n, t.lookahead + t.insert >= at)
                        for (o = t.strstart - t.insert, t.ins_h = t.window[o], t.ins_h = (t.ins_h << t.hash_shift ^ t.window[o + 1]) & t.hash_mask; t.insert && (t.ins_h = (t.ins_h << t.hash_shift ^ t.window[o + at - 1]) & t.hash_mask, t.prev[o & t.w_mask] = t.head[t.ins_h], t.head[t.ins_h] = o, o++, t.insert--, !(t.lookahead + t.insert < at)););
                } while (t.lookahead < ut && 0 !== t.strm.avail_in)
            }

            function f(t, e) {
                var n = 65535;
                for (n > t.pending_buf_size - 5 && (n = t.pending_buf_size - 5);;) {
                    if (t.lookahead <= 1) {
                        if (d(t), 0 === t.lookahead && e === $) return yt;
                        if (0 === t.lookahead) break
                    }
                    t.strstart += t.lookahead, t.lookahead = 0;
                    var i = t.block_start + n;
                    if ((0 === t.strstart || t.strstart >= i) && (t.lookahead = t.strstart - i, t.strstart = i, a(t, !1), 0 === t.strm.avail_out)) return yt;
                    if (t.strstart - t.block_start >= t.w_size - ut && (a(t, !1), 0 === t.strm.avail_out)) return yt
                }
                return t.insert = 0, e === M ? (a(t, !0), 0 === t.strm.avail_out ? _t : wt) : (t.strstart > t.block_start && (a(t, !1), t.strm.avail_out), yt)
            }

            function p(t, e) {
                for (var n, i;;) {
                    if (t.lookahead < ut) {
                        if (d(t), t.lookahead < ut && e === $) return yt;
                        if (0 === t.lookahead) break
                    }
                    if (n = 0, t.lookahead >= at && (t.ins_h = (t.ins_h << t.hash_shift ^ t.window[t.strstart + at - 1]) & t.hash_mask, n = t.prev[t.strstart & t.w_mask] = t.head[t.ins_h], t.head[t.ins_h] = t.strstart), 0 !== n && t.strstart - n <= t.w_size - ut && (t.match_length = h(t, n)), t.match_length >= at)
                        if (i = O._tr_tally(t, t.strstart - t.match_start, t.match_length - at), t.lookahead -= t.match_length, t.match_length <= t.max_lazy_match && t.lookahead >= at) {
                            t.match_length--;
                            do {
                                t.strstart++, t.ins_h = (t.ins_h << t.hash_shift ^ t.window[t.strstart + at - 1]) & t.hash_mask, n = t.prev[t.strstart & t.w_mask] = t.head[t.ins_h], t.head[t.ins_h] = t.strstart
                            } while (0 != --t.match_length);
                            t.strstart++
                        } else t.strstart += t.match_length, t.match_length = 0,
                            t.ins_h = t.window[t.strstart], t.ins_h = (t.ins_h << t.hash_shift ^ t.window[t.strstart + 1]) & t.hash_mask;
                    else i = O._tr_tally(t, 0, t.window[t.strstart]), t.lookahead--, t.strstart++;
                    if (i && (a(t, !1), 0 === t.strm.avail_out)) return yt
                }
                return t.insert = t.strstart < at - 1 ? t.strstart : at - 1, e === M ? (a(t, !0), 0 === t.strm.avail_out ? _t : wt) : t.last_lit && (a(t, !1), 0 === t.strm.avail_out) ? yt : bt
            }

            function m(t, e) {
                for (var n, i, r;;) {
                    if (t.lookahead < ut) {
                        if (d(t), t.lookahead < ut && e === $) return yt;
                        if (0 === t.lookahead) break
                    }
                    if (n = 0, t.lookahead >= at && (t.ins_h = (t.ins_h << t.hash_shift ^ t.window[t.strstart + at - 1]) & t.hash_mask, n = t.prev[t.strstart & t.w_mask] = t.head[t.ins_h], t.head[t.ins_h] = t.strstart), t.prev_length = t.match_length, t.prev_match = t.match_start, t.match_length = at - 1, 0 !== n && t.prev_length < t.max_lazy_match && t.strstart - n <= t.w_size - ut && (t.match_length = h(t, n), t.match_length <= 5 && (t.strategy === V || t.match_length === at && t.strstart - t.match_start > 4096) && (t.match_length = at - 1)), t.prev_length >= at && t.match_length <= t.prev_length) {
                        r = t.strstart + t.lookahead - at, i = O._tr_tally(t, t.strstart - 1 - t.prev_match, t.prev_length - at), t.lookahead -= t.prev_length - 1, t.prev_length -= 2;
                        do {
                            ++t.strstart <= r && (t.ins_h = (t.ins_h << t.hash_shift ^ t.window[t.strstart + at - 1]) & t.hash_mask, n = t.prev[t.strstart & t.w_mask] = t.head[t.ins_h], t.head[t.ins_h] = t.strstart)
                        } while (0 != --t.prev_length);
                        if (t.match_available = 0, t.match_length = at - 1, t.strstart++, i && (a(t, !1), 0 === t.strm.avail_out)) return yt
                    } else if (t.match_available) {
                        if (i = O._tr_tally(t, 0, t.window[t.strstart - 1]), i && a(t, !1), t.strstart++, t.lookahead--, 0 === t.strm.avail_out) return yt
                    } else t.match_available = 1, t.strstart++, t.lookahead--
                }
                return t.match_available && (i = O._tr_tally(t, 0, t.window[t.strstart - 1]), t.match_available = 0), t.insert = t.strstart < at - 1 ? t.strstart : at - 1, e === M ? (a(t, !0), 0 === t.strm.avail_out ? _t : wt) : t.last_lit && (a(t, !1), 0 === t.strm.avail_out) ? yt : bt
            }

            function g(t, e) {
                for (var n, i, r, o, s = t.window;;) {
                    if (t.lookahead <= lt) {
                        if (d(t), t.lookahead <= lt && e === $) return yt;
                        if (0 === t.lookahead) break
                    }
                    if (t.match_length = 0, t.lookahead >= at && t.strstart > 0 && (r = t.strstart - 1, (i = s[r]) === s[++r] && i === s[++r] && i === s[++r])) {
                        o = t.strstart + lt;
                        do {} while (i === s[++r] && i === s[++r] && i === s[++r] && i === s[++r] && i === s[++r] && i === s[++r] && i === s[++r] && i === s[++r] && r < o);
                        t.match_length = lt - (o - r), t.match_length > t.lookahead && (t.match_length = t.lookahead)
                    }
                    if (t.match_length >= at ? (n = O._tr_tally(t, 1, t.match_length - at), t.lookahead -= t.match_length, t.strstart += t.match_length, t.match_length = 0) : (n = O._tr_tally(t, 0, t.window[t.strstart]), t.lookahead--, t.strstart++), n && (a(t, !1), 0 === t.strm.avail_out)) return yt
                }
                return t.insert = 0, e === M ? (a(t, !0), 0 === t.strm.avail_out ? _t : wt) : t.last_lit && (a(t, !1), 0 === t.strm.avail_out) ? yt : bt
            }

            function v(t, e) {
                for (var n;;) {
                    if (0 === t.lookahead && (d(t), 0 === t.lookahead)) {
                        if (e === $) return yt;
                        break
                    }
                    if (t.match_length = 0, n = O._tr_tally(t, 0, t.window[t.strstart]), t.lookahead--, t.strstart++, n && (a(t, !1), 0 === t.strm.avail_out)) return yt
                }
                return t.insert = 0, e === M ? (a(t, !0), 0 === t.strm.avail_out ? _t : wt) : t.last_lit && (a(t, !1), 0 === t.strm.avail_out) ? yt : bt
            }

            function y(t, e, n, i, r) {
                this.good_length = t, this.max_lazy = e, this.nice_length = n, this.max_chain = i, this.func = r
            }

            function b(t) {
                t.window_size = 2 * t.w_size, o(t.head), t.max_lazy_match = N[t.level].max_lazy, t.good_match = N[t.level].good_length, t.nice_match = N[t.level].nice_length, t.max_chain_length = N[t.level].max_chain, t.strstart = 0, t.block_start = 0, t.lookahead = 0, t.insert = 0, t.match_length = t.prev_length = at - 1, t.match_available = 0, t.ins_h = 0
            }

            function _() {
                this.strm = null, this.status = 0, this.pending_buf = null, this.pending_buf_size = 0, this.pending_out = 0, this.pending = 0, this.wrap = 0, this.gzhead = null, this.gzindex = 0, this.method = Y, this.last_flush = -1, this.w_size = 0, this.w_bits = 0, this.w_mask = 0, this.window = null, this.window_size = 0, this.prev = null, this.head = null, this.ins_h = 0, this.hash_size = 0, this.hash_bits = 0, this.hash_mask = 0, this.hash_shift = 0, this.block_start = 0, this.match_length = 0, this.prev_match = 0, this.match_available = 0, this.strstart = 0, this.match_start = 0, this.lookahead = 0, this.prev_length = 0, this.max_chain_length = 0, this.max_lazy_match = 0, this.level = 0, this.strategy = 0, this.good_match = 0, this.nice_match = 0, this.dyn_ltree = new D.Buf16(2 * ot), this.dyn_dtree = new D.Buf16(2 * (2 * it + 1)), this.bl_tree = new D.Buf16(2 * (2 * rt + 1)), o(this.dyn_ltree), o(this.dyn_dtree), o(this.bl_tree), this.l_desc = null, this.d_desc = null, this.bl_desc = null, this.bl_count = new D.Buf16(st + 1), this.heap = new D.Buf16(2 * nt + 1), o(this.heap), this.heap_len = 0, this.heap_max = 0, this.depth = new D.Buf16(2 * nt + 1), o(this.depth), this.l_buf = 0, this.lit_bufsize = 0, this.last_lit = 0, this.d_buf = 0, this.opt_len = 0, this.static_len = 0, this.matches = 0, this.insert = 0, this.bi_buf = 0, this.bi_valid = 0
            }

            function w(t) {
                var e;
                return t && t.state ? (t.total_in = t.total_out = 0, t.data_type = Q, e = t.state, e.pending = 0, e.pending_out = 0, e.wrap < 0 && (e.wrap = -e.wrap), e.status = e.wrap ? ht : gt, t.adler = 2 === e.wrap ? 0 : 1, e.last_flush = $, O._tr_init(e), F) : i(t, H)
            }

            function x(t) {
                var e = w(t);
                return e === F && b(t.state), e
            }

            function k(t, e) {
                return t && t.state ? 2 !== t.state.wrap ? H : (t.state.gzhead = e, F) : H
            }

            function C(t, e, n, r, o, s) {
                if (!t) return H;
                var a = 1;
                if (e === q && (e = 6), r < 0 ? (a = 0, r = -r) : r > 15 && (a = 2, r -= 16), o < 1 || o > J || n !== Y || r < 8 || r > 15 || e < 0 || e > 9 || s < 0 || s > G) return i(t, H);
                8 === r && (r = 9);
                var l = new _;
                return t.state = l, l.strm = t, l.wrap = a, l.gzhead = null, l.w_bits = r, l.w_size = 1 << l.w_bits, l.w_mask = l.w_size - 1, l.hash_bits = o + 7, l.hash_size = 1 << l.hash_bits, l.hash_mask = l.hash_size - 1, l.hash_shift = ~~((l.hash_bits + at - 1) / at), l.window = new D.Buf8(2 * l.w_size), l.head = new D.Buf16(l.hash_size), l.prev = new D.Buf16(l.w_size), l.lit_bufsize = 1 << o + 6, l.pending_buf_size = 4 * l.lit_bufsize, l.pending_buf = new D.Buf8(l.pending_buf_size), l.d_buf = 1 * l.lit_bufsize, l.l_buf = 3 * l.lit_bufsize, l.level = e, l.strategy = s, l.method = n, x(t)
            }

            function E(t, e) {
                return C(t, e, Y, tt, et, K)
            }

            function T(t, e) {
                var n, a, c, h;
                if (!t || !t.state || e > j || e < 0) return t ? i(t, H) : H;
                if (a = t.state, !t.output || !t.input && 0 !== t.avail_in || a.status === vt && e !== M) return i(t, 0 === t.avail_out ? U : H);
                if (a.strm = t, n = a.last_flush, a.last_flush = e, a.status === ht)
                    if (2 === a.wrap) t.adler = 0, l(a, 31), l(a, 139), l(a, 8), a.gzhead ? (l(a, (a.gzhead.text ? 1 : 0) + (a.gzhead.hcrc ? 2 : 0) + (a.gzhead.extra ? 4 : 0) + (a.gzhead.name ? 8 : 0) + (a.gzhead.comment ? 16 : 0)), l(a, 255 & a.gzhead.time), l(a, a.gzhead.time >> 8 & 255), l(a, a.gzhead.time >> 16 & 255), l(a, a.gzhead.time >> 24 & 255), l(a, 9 === a.level ? 2 : a.strategy >= Z || a.level < 2 ? 4 : 0), l(a, 255 & a.gzhead.os), a.gzhead.extra && a.gzhead.extra.length && (l(a, 255 & a.gzhead.extra.length), l(a, a.gzhead.extra.length >> 8 & 255)), a.gzhead.hcrc && (t.adler = z(t.adler, a.pending_buf, a.pending, 0)), a.gzindex = 0, a.status = dt) : (l(a, 0), l(a, 0), l(a, 0), l(a, 0), l(a, 0), l(a, 9 === a.level ? 2 : a.strategy >= Z || a.level < 2 ? 4 : 0), l(a, xt), a.status = gt);
                    else {
                        var d = Y + (a.w_bits - 8 << 4) << 8,
                            f = -1;
                        f = a.strategy >= Z || a.level < 2 ? 0 : a.level < 6 ? 1 : 6 === a.level ? 2 : 3, d |= f << 6, 0 !== a.strstart && (d |= ct), d += 31 - d % 31, a.status = gt, u(a, d), 0 !== a.strstart && (u(a, t.adler >>> 16), u(a, 65535 & t.adler)), t.adler = 1
                    } if (a.status === dt)
                    if (a.gzhead.extra) {
                        for (c = a.pending; a.gzindex < (65535 & a.gzhead.extra.length) && (a.pending !== a.pending_buf_size || (a.gzhead.hcrc && a.pending > c && (t.adler = z(t.adler, a.pending_buf, a.pending - c, c)), s(t), c = a.pending, a.pending !== a.pending_buf_size));) l(a, 255 & a.gzhead.extra[a.gzindex]), a.gzindex++;
                        a.gzhead.hcrc && a.pending > c && (t.adler = z(t.adler, a.pending_buf, a.pending - c, c)), a.gzindex === a.gzhead.extra.length && (a.gzindex = 0, a.status = ft)
                    } else a.status = ft;
                if (a.status === ft)
                    if (a.gzhead.name) {
                        c = a.pending;
                        do {
                            if (a.pending === a.pending_buf_size && (a.gzhead.hcrc && a.pending > c && (t.adler = z(t.adler, a.pending_buf, a.pending - c, c)), s(t), c = a.pending, a.pending === a.pending_buf_size)) {
                                h = 1;
                                break
                            }
                            h = a.gzindex < a.gzhead.name.length ? 255 & a.gzhead.name.charCodeAt(a.gzindex++) : 0, l(a, h)
                        } while (0 !== h);
                        a.gzhead.hcrc && a.pending > c && (t.adler = z(t.adler, a.pending_buf, a.pending - c, c)), 0 === h && (a.gzindex = 0, a.status = pt)
                    } else a.status = pt;
                if (a.status === pt)
                    if (a.gzhead.comment) {
                        c = a.pending;
                        do {
                            if (a.pending === a.pending_buf_size && (a.gzhead.hcrc && a.pending > c && (t.adler = z(t.adler, a.pending_buf, a.pending - c, c)), s(t), c = a.pending, a.pending === a.pending_buf_size)) {
                                h = 1;
                                break
                            }
                            h = a.gzindex < a.gzhead.comment.length ? 255 & a.gzhead.comment.charCodeAt(a.gzindex++) : 0, l(a, h)
                        } while (0 !== h);
                        a.gzhead.hcrc && a.pending > c && (t.adler = z(t.adler, a.pending_buf, a.pending - c, c)), 0 === h && (a.status = mt)
                    } else a.status = mt;
                if (a.status === mt && (a.gzhead.hcrc ? (a.pending + 2 > a.pending_buf_size && s(t), a.pending + 2 <= a.pending_buf_size && (l(a, 255 & t.adler), l(a, t.adler >> 8 & 255), t.adler = 0, a.status = gt)) : a.status = gt), 0 !== a.pending) {
                    if (s(t), 0 === t.avail_out) return a.last_flush = -1, F
                } else if (0 === t.avail_in && r(e) <= r(n) && e !== M) return i(t, U);
                if (a.status === vt && 0 !== t.avail_in) return i(t, U);
                if (0 !== t.avail_in || 0 !== a.lookahead || e !== $ && a.status !== vt) {
                    var p = a.strategy === Z ? v(a, e) : a.strategy === X ? g(a, e) : N[a.level].func(a, e);
                    if (p !== _t && p !== wt || (a.status = vt), p === yt || p === _t) return 0 === t.avail_out && (a.last_flush = -1), F;
                    if (p === bt && (e === R ? O._tr_align(a) : e !== j && (O._tr_stored_block(a, 0, 0, !1), e === P && (o(a.head), 0 === a.lookahead && (a.strstart = 0, a.block_start = 0, a.insert = 0))), s(t), 0 === t.avail_out)) return a.last_flush = -1, F
                }
                return e !== M ? F : a.wrap <= 0 ? B : (2 === a.wrap ? (l(a, 255 & t.adler), l(a, t.adler >> 8 & 255), l(a, t.adler >> 16 & 255), l(a, t.adler >> 24 & 255), l(a, 255 & t.total_in), l(a, t.total_in >> 8 & 255), l(a, t.total_in >> 16 & 255), l(a, t.total_in >> 24 & 255)) : (u(a, t.adler >>> 16), u(a, 65535 & t.adler)), s(t), a.wrap > 0 && (a.wrap = -a.wrap), 0 !== a.pending ? F : B)
            }

            function S(t) {
                var e;
                return t && t.state ? (e = t.state.status, e !== ht && e !== dt && e !== ft && e !== pt && e !== mt && e !== gt && e !== vt ? i(t, H) : (t.state = null, e === gt ? i(t, W) : F)) : H
            }

            function A(t, e) {
                var n, i, r, s, a, l, u, c, h = e.length;
                if (!t || !t.state) return H;
                if (n = t.state, 2 === (s = n.wrap) || 1 === s && n.status !== ht || n.lookahead) return H;
                for (1 === s && (t.adler = I(t.adler, e, h, 0)), n.wrap = 0, h >= n.w_size && (0 === s && (o(n.head), n.strstart = 0, n.block_start = 0, n.insert = 0), c = new D.Buf8(n.w_size), D.arraySet(c, e, h - n.w_size, n.w_size, 0), e = c, h = n.w_size), a = t.avail_in, l = t.next_in, u = t.input, t.avail_in = h, t.next_in = 0, t.input = e, d(n); n.lookahead >= at;) {
                    i = n.strstart, r = n.lookahead - (at - 1);
                    do {
                        n.ins_h = (n.ins_h << n.hash_shift ^ n.window[i + at - 1]) & n.hash_mask, n.prev[i & n.w_mask] = n.head[n.ins_h], n.head[n.ins_h] = i, i++
                    } while (--r);
                    n.strstart = i, n.lookahead = at - 1, d(n)
                }
                return n.strstart += n.lookahead, n.block_start = n.strstart, n.insert = n.lookahead, n.lookahead = 0, n.match_length = n.prev_length = at - 1, n.match_available = 0, t.next_in = l, t.input = u, t.avail_in = a, n.wrap = s, F
            }
            var N, D = t("../utils/common"),
                O = t("./trees"),
                I = t("./adler32"),
                z = t("./crc32"),
                L = t("./messages"),
                $ = 0,
                R = 1,
                P = 3,
                M = 4,
                j = 5,
                F = 0,
                B = 1,
                H = -2,
                W = -3,
                U = -5,
                q = -1,
                V = 1,
                Z = 2,
                X = 3,
                G = 4,
                K = 0,
                Q = 2,
                Y = 8,
                J = 9,
                tt = 15,
                et = 8,
                nt = 286,
                it = 30,
                rt = 19,
                ot = 2 * nt + 1,
                st = 15,
                at = 3,
                lt = 258,
                ut = lt + at + 1,
                ct = 32,
                ht = 42,
                dt = 69,
                ft = 73,
                pt = 91,
                mt = 103,
                gt = 113,
                vt = 666,
                yt = 1,
                bt = 2,
                _t = 3,
                wt = 4,
                xt = 3;
            N = [new y(0, 0, 0, 0, f), new y(4, 4, 8, 4, p), new y(4, 5, 16, 8, p), new y(4, 6, 32, 32, p), new y(4, 4, 16, 16, m), new y(8, 16, 32, 32, m), new y(8, 16, 128, 128, m), new y(8, 32, 128, 256, m), new y(32, 128, 258, 1024, m), new y(32, 258, 258, 4096, m)], n.deflateInit = E, n.deflateInit2 = C, n.deflateReset = x, n.deflateResetKeep = w, n.deflateSetHeader = k, n.deflate = T, n.deflateEnd = S, n.deflateSetDictionary = A, n.deflateInfo = "pako deflate (from Nodeca project)"
        }, {
            "../utils/common": 62,
            "./adler32": 64,
            "./crc32": 66,
            "./messages": 72,
            "./trees": 73
        }],
        68: [function(t, e, n) {
            "use strict";

            function i() {
                this.text = 0, this.time = 0, this.xflags = 0, this.os = 0, this.extra = null, this.extra_len = 0, this.name = "", this.comment = "", this.hcrc = 0, this.done = !1
            }
            e.exports = i
        }, {}],
        69: [function(t, e, n) {
            "use strict";
            e.exports = function(t, e) {
                var n, i, r, o, s, a, l, u, c, h, d, f, p, m, g, v, y, b, _, w, x, k, C, E, T;
                n = t.state, i = t.next_in, E = t.input, r = i + (t.avail_in - 5), o = t.next_out, T = t.output, s = o - (e - t.avail_out), a = o + (t.avail_out - 257), l = n.dmax, u = n.wsize, c = n.whave, h = n.wnext, d = n.window, f = n.hold, p = n.bits, m = n.lencode, g = n.distcode, v = (1 << n.lenbits) - 1, y = (1 << n.distbits) - 1;
                t: do {
                    p < 15 && (f += E[i++] << p, p += 8, f += E[i++] << p, p += 8), b = m[f & v];
                    e: for (;;) {
                        if (_ = b >>> 24, f >>>= _, p -= _, 0 === (_ = b >>> 16 & 255)) T[o++] = 65535 & b;
                        else {
                            if (!(16 & _)) {
                                if (0 == (64 & _)) {
                                    b = m[(65535 & b) + (f & (1 << _) - 1)];
                                    continue e
                                }
                                if (32 & _) {
                                    n.mode = 12;
                                    break t
                                }
                                t.msg = "invalid literal/length code", n.mode = 30;
                                break t
                            }
                            w = 65535 & b, _ &= 15, _ && (p < _ && (f += E[i++] << p, p += 8), w += f & (1 << _) - 1, f >>>= _, p -= _), p < 15 && (f += E[i++] << p, p += 8, f += E[i++] << p, p += 8), b = g[f & y];
                            n: for (;;) {
                                if (_ = b >>> 24, f >>>= _, p -= _, !(16 & (_ = b >>> 16 & 255))) {
                                    if (0 == (64 & _)) {
                                        b = g[(65535 & b) + (f & (1 << _) - 1)];
                                        continue n
                                    }
                                    t.msg = "invalid distance code", n.mode = 30;
                                    break t
                                }
                                if (x = 65535 & b, _ &= 15, p < _ && (f += E[i++] << p, (p += 8) < _ && (f += E[i++] << p, p += 8)), (x += f & (1 << _) - 1) > l) {
                                    t.msg = "invalid distance too far back", n.mode = 30;
                                    break t
                                }
                                if (f >>>= _, p -= _, _ = o - s, x > _) {
                                    if ((_ = x - _) > c && n.sane) {
                                        t.msg = "invalid distance too far back", n.mode = 30;
                                        break t
                                    }
                                    if (k = 0, C = d, 0 === h) {
                                        if (k += u - _, _ < w) {
                                            w -= _;
                                            do {
                                                T[o++] = d[k++]
                                            } while (--_);
                                            k = o - x, C = T
                                        }
                                    } else if (h < _) {
                                        if (k += u + h - _, (_ -= h) < w) {
                                            w -= _;
                                            do {
                                                T[o++] = d[k++]
                                            } while (--_);
                                            if (k = 0, h < w) {
                                                _ = h, w -= _;
                                                do {
                                                    T[o++] = d[k++]
                                                } while (--_);
                                                k = o - x, C = T
                                            }
                                        }
                                    } else if (k += h - _, _ < w) {
                                        w -= _;
                                        do {
                                            T[o++] = d[k++]
                                        } while (--_);
                                        k = o - x, C = T
                                    }
                                    for (; w > 2;) T[o++] = C[k++], T[o++] = C[k++], T[o++] = C[k++], w -= 3;
                                    w && (T[o++] = C[k++], w > 1 && (T[o++] = C[k++]))
                                } else {
                                    k = o - x;
                                    do {
                                        T[o++] = T[k++], T[o++] = T[k++], T[o++] = T[k++], w -= 3
                                    } while (w > 2);
                                    w && (T[o++] = T[k++], w > 1 && (T[o++] = T[k++]))
                                }
                                break
                            }
                        }
                        break
                    }
                } while (i < r && o < a);
                w = p >> 3, i -= w, p -= w << 3, f &= (1 << p) - 1, t.next_in = i, t.next_out = o, t.avail_in = i < r ? r - i + 5 : 5 - (i - r), t.avail_out = o < a ? a - o + 257 : 257 - (o - a), n.hold = f, n.bits = p
            }
        }, {}],
        70: [function(t, e, n) {
            "use strict";

            function i(t) {
                return (t >>> 24 & 255) + (t >>> 8 & 65280) + ((65280 & t) << 8) + ((255 & t) << 24)
            }

            function r() {
                this.mode = 0, this.last = !1, this.wrap = 0, this.havedict = !1, this.flags = 0, this.dmax = 0, this.check = 0, this.total = 0, this.head = null, this.wbits = 0, this.wsize = 0, this.whave = 0, this.wnext = 0, this.window = null, this.hold = 0, this.bits = 0, this.length = 0, this.offset = 0, this.extra = 0, this.lencode = null, this.distcode = null, this.lenbits = 0, this.distbits = 0, this.ncode = 0, this.nlen = 0, this.ndist = 0, this.have = 0, this.next = null, this.lens = new y.Buf16(320), this.work = new y.Buf16(288), this.lendyn = null, this.distdyn = null, this.sane = 0, this.back = 0, this.was = 0
            }

            function o(t) {
                var e;
                return t && t.state ? (e = t.state, t.total_in = t.total_out = e.total = 0, t.msg = "", e.wrap && (t.adler = 1 & e.wrap), e.mode = P, e.last = 0, e.havedict = 0, e.dmax = 32768, e.head = null, e.hold = 0, e.bits = 0, e.lencode = e.lendyn = new y.Buf32(mt), e.distcode = e.distdyn = new y.Buf32(gt), e.sane = 1, e.back = -1, N) : I
            }

            function s(t) {
                var e;
                return t && t.state ? (e = t.state, e.wsize = 0, e.whave = 0, e.wnext = 0, o(t)) : I
            }

            function a(t, e) {
                var n, i;
                return t && t.state ? (i = t.state, e < 0 ? (n = 0, e = -e) : (n = 1 + (e >> 4), e < 48 && (e &= 15)), e && (e < 8 || e > 15) ? I : (null !== i.window && i.wbits !== e && (i.window = null), i.wrap = n, i.wbits = e, s(t))) : I
            }

            function l(t, e) {
                var n, i;
                return t ? (i = new r, t.state = i, i.window = null, n = a(t, e), n !== N && (t.state = null), n) : I
            }

            function u(t) {
                return l(t, vt)
            }

            function c(t) {
                if (yt) {
                    var e;
                    for (g = new y.Buf32(512), v = new y.Buf32(32), e = 0; e < 144;) t.lens[e++] = 8;
                    for (; e < 256;) t.lens[e++] = 9;
                    for (; e < 280;) t.lens[e++] = 7;
                    for (; e < 288;) t.lens[e++] = 8;
                    for (x(C, t.lens, 0, 288, g, 0, t.work, {
                            bits: 9
                        }), e = 0; e < 32;) t.lens[e++] = 5;
                    x(E, t.lens, 0, 32, v, 0, t.work, {
                        bits: 5
                    }), yt = !1
                }
                t.lencode = g, t.lenbits = 9, t.distcode = v, t.distbits = 5
            }

            function h(t, e, n, i) {
                var r, o = t.state;
                return null === o.window && (o.wsize = 1 << o.wbits, o.wnext = 0, o.whave = 0, o.window = new y.Buf8(o.wsize)), i >= o.wsize ? (y.arraySet(o.window, e, n - o.wsize, o.wsize, 0), o.wnext = 0, o.whave = o.wsize) : (r = o.wsize - o.wnext, r > i && (r = i), y.arraySet(o.window, e, n - i, r, o.wnext), i -= r, i ? (y.arraySet(o.window, e, n - i, i, 0), o.wnext = i, o.whave = o.wsize) : (o.wnext += r, o.wnext === o.wsize && (o.wnext = 0), o.whave < o.wsize && (o.whave += r))), 0
            }

            function d(t, e) {
                var n, r, o, s, a, l, u, d, f, p, m, g, v, mt, gt, vt, yt, bt, _t, wt, xt, kt, Ct, Et, Tt = 0,
                    St = new y.Buf8(4),
                    At = [16, 17, 18, 0, 8, 7, 9, 6, 10, 5, 11, 4, 12, 3, 13, 2, 14, 1, 15];
                if (!t || !t.state || !t.output || !t.input && 0 !== t.avail_in) return I;
                n = t.state, n.mode === X && (n.mode = G), a = t.next_out, o = t.output, u = t.avail_out, s = t.next_in, r = t.input, l = t.avail_in, d = n.hold, f = n.bits, p = l, m = u, kt = N;
                t: for (;;) switch (n.mode) {
                    case P:
                        if (0 === n.wrap) {
                            n.mode = G;
                            break
                        }
                        for (; f < 16;) {
                            if (0 === l) break t;
                            l--, d += r[s++] << f, f += 8
                        }
                        if (2 & n.wrap && 35615 === d) {
                            n.check = 0, St[0] = 255 & d, St[1] = d >>> 8 & 255, n.check = _(n.check, St, 2, 0), d = 0, f = 0, n.mode = M;
                            break
                        }
                        if (n.flags = 0, n.head && (n.head.done = !1), !(1 & n.wrap) || (((255 & d) << 8) + (d >> 8)) % 31) {
                            t.msg = "incorrect header check", n.mode = dt;
                            break
                        }
                        if ((15 & d) !== R) {
                            t.msg = "unknown compression method", n.mode = dt;
                            break
                        }
                        if (d >>>= 4, f -= 4, xt = 8 + (15 & d), 0 === n.wbits) n.wbits = xt;
                        else if (xt > n.wbits) {
                            t.msg = "invalid window size", n.mode = dt;
                            break
                        }
                        n.dmax = 1 << xt, t.adler = n.check = 1, n.mode = 512 & d ? V : X, d = 0, f = 0;
                        break;
                    case M:
                        for (; f < 16;) {
                            if (0 === l) break t;
                            l--, d += r[s++] << f, f += 8
                        }
                        if (n.flags = d, (255 & n.flags) !== R) {
                            t.msg = "unknown compression method", n.mode = dt;
                            break
                        }
                        if (57344 & n.flags) {
                            t.msg = "unknown header flags set", n.mode = dt;
                            break
                        }
                        n.head && (n.head.text = d >> 8 & 1), 512 & n.flags && (St[0] = 255 & d, St[1] = d >>> 8 & 255, n.check = _(n.check, St, 2, 0)), d = 0, f = 0, n.mode = j;
                    case j:
                        for (; f < 32;) {
                            if (0 === l) break t;
                            l--, d += r[s++] << f, f += 8
                        }
                        n.head && (n.head.time = d), 512 & n.flags && (St[0] = 255 & d, St[1] = d >>> 8 & 255, St[2] = d >>> 16 & 255, St[3] = d >>> 24 & 255, n.check = _(n.check, St, 4, 0)), d = 0, f = 0, n.mode = F;
                    case F:
                        for (; f < 16;) {
                            if (0 === l) break t;
                            l--, d += r[s++] << f, f += 8
                        }
                        n.head && (n.head.xflags = 255 & d, n.head.os = d >> 8), 512 & n.flags && (St[0] = 255 & d, St[1] = d >>> 8 & 255, n.check = _(n.check, St, 2, 0)), d = 0, f = 0, n.mode = B;
                    case B:
                        if (1024 & n.flags) {
                            for (; f < 16;) {
                                if (0 === l) break t;
                                l--, d += r[s++] << f, f += 8
                            }
                            n.length = d, n.head && (n.head.extra_len = d), 512 & n.flags && (St[0] = 255 & d, St[1] = d >>> 8 & 255, n.check = _(n.check, St, 2, 0)), d = 0, f = 0
                        } else n.head && (n.head.extra = null);
                        n.mode = H;
                    case H:
                        if (1024 & n.flags && (g = n.length, g > l && (g = l), g && (n.head && (xt = n.head.extra_len - n.length, n.head.extra || (n.head.extra = new Array(n.head.extra_len)), y.arraySet(n.head.extra, r, s, g, xt)), 512 & n.flags && (n.check = _(n.check, r, g, s)), l -= g, s += g, n.length -= g), n.length)) break t;
                        n.length = 0, n.mode = W;
                    case W:
                        if (2048 & n.flags) {
                            if (0 === l) break t;
                            g = 0;
                            do {
                                xt = r[s + g++], n.head && xt && n.length < 65536 && (n.head.name += String.fromCharCode(xt))
                            } while (xt && g < l);
                            if (512 & n.flags && (n.check = _(n.check, r, g, s)), l -= g, s += g, xt) break t
                        } else n.head && (n.head.name = null);
                        n.length = 0, n.mode = U;
                    case U:
                        if (4096 & n.flags) {
                            if (0 === l) break t;
                            g = 0;
                            do {
                                xt = r[s + g++], n.head && xt && n.length < 65536 && (n.head.comment += String.fromCharCode(xt))
                            } while (xt && g < l);
                            if (512 & n.flags && (n.check = _(n.check, r, g, s)), l -= g, s += g, xt) break t
                        } else n.head && (n.head.comment = null);
                        n.mode = q;
                    case q:
                        if (512 & n.flags) {
                            for (; f < 16;) {
                                if (0 === l) break t;
                                l--, d += r[s++] << f, f += 8
                            }
                            if (d !== (65535 & n.check)) {
                                t.msg = "header crc mismatch", n.mode = dt;
                                break
                            }
                            d = 0, f = 0
                        }
                        n.head && (n.head.hcrc = n.flags >> 9 & 1, n.head.done = !0), t.adler = n.check = 0, n.mode = X;
                        break;
                    case V:
                        for (; f < 32;) {
                            if (0 === l) break t;
                            l--, d += r[s++] << f, f += 8
                        }
                        t.adler = n.check = i(d), d = 0, f = 0, n.mode = Z;
                    case Z:
                        if (0 === n.havedict) return t.next_out = a, t.avail_out = u, t.next_in = s, t.avail_in = l, n.hold = d, n.bits = f, O;
                        t.adler = n.check = 1, n.mode = X;
                    case X:
                        if (e === S || e === A) break t;
                    case G:
                        if (n.last) {
                            d >>>= 7 & f, f -= 7 & f, n.mode = ut;
                            break
                        }
                        for (; f < 3;) {
                            if (0 === l) break t;
                            l--, d += r[s++] << f, f += 8
                        }
                        switch (n.last = 1 & d, d >>>= 1, f -= 1, 3 & d) {
                            case 0:
                                n.mode = K;
                                break;
                            case 1:
                                if (c(n), n.mode = nt, e === A) {
                                    d >>>= 2, f -= 2;
                                    break t
                                }
                                break;
                            case 2:
                                n.mode = J;
                                break;
                            case 3:
                                t.msg = "invalid block type", n.mode = dt
                        }
                        d >>>= 2, f -= 2;
                        break;
                    case K:
                        for (d >>>= 7 & f, f -= 7 & f; f < 32;) {
                            if (0 === l) break t;
                            l--, d += r[s++] << f, f += 8
                        }
                        if ((65535 & d) != (d >>> 16 ^ 65535)) {
                            t.msg = "invalid stored block lengths", n.mode = dt;
                            break
                        }
                        if (n.length = 65535 & d, d = 0, f = 0, n.mode = Q, e === A) break t;
                    case Q:
                        n.mode = Y;
                    case Y:
                        if (g = n.length) {
                            if (g > l && (g = l), g > u && (g = u), 0 === g) break t;
                            y.arraySet(o, r, s, g, a), l -= g, s += g, u -= g, a += g, n.length -= g;
                            break
                        }
                        n.mode = X;
                        break;
                    case J:
                        for (; f < 14;) {
                            if (0 === l) break t;
                            l--, d += r[s++] << f, f += 8
                        }
                        if (n.nlen = 257 + (31 & d), d >>>= 5, f -= 5, n.ndist = 1 + (31 & d), d >>>= 5, f -= 5, n.ncode = 4 + (15 & d), d >>>= 4, f -= 4, n.nlen > 286 || n.ndist > 30) {
                            t.msg = "too many length or distance symbols", n.mode = dt;
                            break
                        }
                        n.have = 0, n.mode = tt;
                    case tt:
                        for (; n.have < n.ncode;) {
                            for (; f < 3;) {
                                if (0 === l) break t;
                                l--, d += r[s++] << f, f += 8
                            }
                            n.lens[At[n.have++]] = 7 & d, d >>>= 3, f -= 3
                        }
                        for (; n.have < 19;) n.lens[At[n.have++]] = 0;
                        if (n.lencode = n.lendyn, n.lenbits = 7, Ct = {
                                bits: n.lenbits
                            }, kt = x(k, n.lens, 0, 19, n.lencode, 0, n.work, Ct), n.lenbits = Ct.bits, kt) {
                            t.msg = "invalid code lengths set", n.mode = dt;
                            break
                        }
                        n.have = 0, n.mode = et;
                    case et:
                        for (; n.have < n.nlen + n.ndist;) {
                            for (; Tt = n.lencode[d & (1 << n.lenbits) - 1], gt = Tt >>> 24, vt = Tt >>> 16 & 255, yt = 65535 & Tt, !(gt <= f);) {
                                if (0 === l) break t;
                                l--, d += r[s++] << f, f += 8
                            }
                            if (yt < 16) d >>>= gt, f -= gt, n.lens[n.have++] = yt;
                            else {
                                if (16 === yt) {
                                    for (Et = gt + 2; f < Et;) {
                                        if (0 === l) break t;
                                        l--, d += r[s++] << f, f += 8
                                    }
                                    if (d >>>= gt, f -= gt, 0 === n.have) {
                                        t.msg = "invalid bit length repeat", n.mode = dt;
                                        break
                                    }
                                    xt = n.lens[n.have - 1], g = 3 + (3 & d), d >>>= 2, f -= 2
                                } else if (17 === yt) {
                                    for (Et = gt + 3; f < Et;) {
                                        if (0 === l) break t;
                                        l--, d += r[s++] << f, f += 8
                                    }
                                    d >>>= gt, f -= gt, xt = 0, g = 3 + (7 & d), d >>>= 3, f -= 3
                                } else {
                                    for (Et = gt + 7; f < Et;) {
                                        if (0 === l) break t;
                                        l--, d += r[s++] << f, f += 8
                                    }
                                    d >>>= gt, f -= gt, xt = 0, g = 11 + (127 & d), d >>>= 7, f -= 7
                                }
                                if (n.have + g > n.nlen + n.ndist) {
                                    t.msg = "invalid bit length repeat", n.mode = dt;
                                    break
                                }
                                for (; g--;) n.lens[n.have++] = xt
                            }
                        }
                        if (n.mode === dt) break;
                        if (0 === n.lens[256]) {
                            t.msg = "invalid code -- missing end-of-block", n.mode = dt;
                            break
                        }
                        if (n.lenbits = 9, Ct = {
                                bits: n.lenbits
                            }, kt = x(C, n.lens, 0, n.nlen, n.lencode, 0, n.work, Ct), n.lenbits = Ct.bits, kt) {
                            t.msg = "invalid literal/lengths set", n.mode = dt;
                            break
                        }
                        if (n.distbits = 6, n.distcode = n.distdyn, Ct = {
                                bits: n.distbits
                            }, kt = x(E, n.lens, n.nlen, n.ndist, n.distcode, 0, n.work, Ct), n.distbits = Ct.bits, kt) {
                            t.msg = "invalid distances set", n.mode = dt;
                            break
                        }
                        if (n.mode = nt, e === A) break t;
                    case nt:
                        n.mode = it;
                    case it:
                        if (l >= 6 && u >= 258) {
                            t.next_out = a, t.avail_out = u, t.next_in = s, t.avail_in = l, n.hold = d, n.bits = f, w(t, m), a = t.next_out, o = t.output, u = t.avail_out, s = t.next_in, r = t.input, l = t.avail_in, d = n.hold, f = n.bits, n.mode === X && (n.back = -1);
                            break
                        }
                        for (n.back = 0; Tt = n.lencode[d & (1 << n.lenbits) - 1], gt = Tt >>> 24, vt = Tt >>> 16 & 255, yt = 65535 & Tt, !(gt <= f);) {
                            if (0 === l) break t;
                            l--, d += r[s++] << f, f += 8
                        }
                        if (vt && 0 == (240 & vt)) {
                            for (bt = gt, _t = vt, wt = yt; Tt = n.lencode[wt + ((d & (1 << bt + _t) - 1) >> bt)], gt = Tt >>> 24, vt = Tt >>> 16 & 255, yt = 65535 & Tt, !(bt + gt <= f);) {
                                if (0 === l) break t;
                                l--, d += r[s++] << f, f += 8
                            }
                            d >>>= bt, f -= bt, n.back += bt
                        }
                        if (d >>>= gt, f -= gt, n.back += gt, n.length = yt, 0 === vt) {
                            n.mode = lt;
                            break
                        }
                        if (32 & vt) {
                            n.back = -1, n.mode = X;
                            break
                        }
                        if (64 & vt) {
                            t.msg = "invalid literal/length code", n.mode = dt;
                            break
                        }
                        n.extra = 15 & vt, n.mode = rt;
                    case rt:
                        if (n.extra) {
                            for (Et = n.extra; f < Et;) {
                                if (0 === l) break t;
                                l--, d += r[s++] << f, f += 8
                            }
                            n.length += d & (1 << n.extra) - 1, d >>>= n.extra, f -= n.extra, n.back += n.extra
                        }
                        n.was = n.length, n.mode = ot;
                    case ot:
                        for (; Tt = n.distcode[d & (1 << n.distbits) - 1], gt = Tt >>> 24, vt = Tt >>> 16 & 255, yt = 65535 & Tt, !(gt <= f);) {
                            if (0 === l) break t;
                            l--, d += r[s++] << f, f += 8
                        }
                        if (0 == (240 & vt)) {
                            for (bt = gt, _t = vt, wt = yt; Tt = n.distcode[wt + ((d & (1 << bt + _t) - 1) >> bt)], gt = Tt >>> 24, vt = Tt >>> 16 & 255, yt = 65535 & Tt, !(bt + gt <= f);) {
                                if (0 === l) break t;
                                l--, d += r[s++] << f, f += 8
                            }
                            d >>>= bt, f -= bt, n.back += bt
                        }
                        if (d >>>= gt, f -= gt, n.back += gt, 64 & vt) {
                            t.msg = "invalid distance code", n.mode = dt;
                            break
                        }
                        n.offset = yt, n.extra = 15 & vt, n.mode = st;
                    case st:
                        if (n.extra) {
                            for (Et = n.extra; f < Et;) {
                                if (0 === l) break t;
                                l--, d += r[s++] << f, f += 8
                            }
                            n.offset += d & (1 << n.extra) - 1, d >>>= n.extra, f -= n.extra, n.back += n.extra
                        }
                        if (n.offset > n.dmax) {
                            t.msg = "invalid distance too far back", n.mode = dt;
                            break
                        }
                        n.mode = at;
                    case at:
                        if (0 === u) break t;
                        if (g = m - u, n.offset > g) {
                            if ((g = n.offset - g) > n.whave && n.sane) {
                                t.msg = "invalid distance too far back", n.mode = dt;
                                break
                            }
                            g > n.wnext ? (g -= n.wnext, v = n.wsize - g) : v = n.wnext - g, g > n.length && (g = n.length), mt = n.window
                        } else mt = o, v = a - n.offset, g = n.length;
                        g > u && (g = u), u -= g, n.length -= g;
                        do {
                            o[a++] = mt[v++]
                        } while (--g);
                        0 === n.length && (n.mode = it);
                        break;
                    case lt:
                        if (0 === u) break t;
                        o[a++] = n.length, u--, n.mode = it;
                        break;
                    case ut:
                        if (n.wrap) {
                            for (; f < 32;) {
                                if (0 === l) break t;
                                l--, d |= r[s++] << f, f += 8
                            }
                            if (m -= u, t.total_out += m, n.total += m, m && (t.adler = n.check = n.flags ? _(n.check, o, m, a - m) : b(n.check, o, m, a - m)), m = u, (n.flags ? d : i(d)) !== n.check) {
                                t.msg = "incorrect data check", n.mode = dt;
                                break
                            }
                            d = 0, f = 0
                        }
                        n.mode = ct;
                    case ct:
                        if (n.wrap && n.flags) {
                            for (; f < 32;) {
                                if (0 === l) break t;
                                l--, d += r[s++] << f, f += 8
                            }
                            if (d !== (4294967295 & n.total)) {
                                t.msg = "incorrect length check", n.mode = dt;
                                break
                            }
                            d = 0, f = 0
                        }
                        n.mode = ht;
                    case ht:
                        kt = D;
                        break t;
                    case dt:
                        kt = z;
                        break t;
                    case ft:
                        return L;
                    case pt:
                    default:
                        return I
                }
                return t.next_out = a, t.avail_out = u, t.next_in = s, t.avail_in = l, n.hold = d, n.bits = f, (n.wsize || m !== t.avail_out && n.mode < dt && (n.mode < ut || e !== T)) && h(t, t.output, t.next_out, m - t.avail_out) ? (n.mode = ft, L) : (p -= t.avail_in, m -= t.avail_out, t.total_in += p, t.total_out += m, n.total += m, n.wrap && m && (t.adler = n.check = n.flags ? _(n.check, o, m, t.next_out - m) : b(n.check, o, m, t.next_out - m)), t.data_type = n.bits + (n.last ? 64 : 0) + (n.mode === X ? 128 : 0) + (n.mode === nt || n.mode === Q ? 256 : 0), (0 === p && 0 === m || e === T) && kt === N && (kt = $), kt)
            }

            function f(t) {
                if (!t || !t.state) return I;
                var e = t.state;
                return e.window && (e.window = null), t.state = null, N
            }

            function p(t, e) {
                var n;
                return t && t.state ? (n = t.state, 0 == (2 & n.wrap) ? I : (n.head = e, e.done = !1, N)) : I
            }

            function m(t, e) {
                var n, i, r = e.length;
                return t && t.state ? (n = t.state, 0 !== n.wrap && n.mode !== Z ? I : n.mode === Z && (i = 1, (i = b(i, e, r, 0)) !== n.check) ? z : h(t, e, r, r) ? (n.mode = ft, L) : (n.havedict = 1, N)) : I
            }
            var g, v, y = t("../utils/common"),
                b = t("./adler32"),
                _ = t("./crc32"),
                w = t("./inffast"),
                x = t("./inftrees"),
                k = 0,
                C = 1,
                E = 2,
                T = 4,
                S = 5,
                A = 6,
                N = 0,
                D = 1,
                O = 2,
                I = -2,
                z = -3,
                L = -4,
                $ = -5,
                R = 8,
                P = 1,
                M = 2,
                j = 3,
                F = 4,
                B = 5,
                H = 6,
                W = 7,
                U = 8,
                q = 9,
                V = 10,
                Z = 11,
                X = 12,
                G = 13,
                K = 14,
                Q = 15,
                Y = 16,
                J = 17,
                tt = 18,
                et = 19,
                nt = 20,
                it = 21,
                rt = 22,
                ot = 23,
                st = 24,
                at = 25,
                lt = 26,
                ut = 27,
                ct = 28,
                ht = 29,
                dt = 30,
                ft = 31,
                pt = 32,
                mt = 852,
                gt = 592,
                vt = 15,
                yt = !0;
            n.inflateReset = s, n.inflateReset2 = a, n.inflateResetKeep = o, n.inflateInit = u, n.inflateInit2 = l, n.inflate = d, n.inflateEnd = f, n.inflateGetHeader = p, n.inflateSetDictionary = m, n.inflateInfo = "pako inflate (from Nodeca project)"
        }, {
            "../utils/common": 62,
            "./adler32": 64,
            "./crc32": 66,
            "./inffast": 69,
            "./inftrees": 71
        }],
        71: [function(t, e, n) {
            "use strict";
            var i = t("../utils/common"),
                r = 15,
                o = [3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 15, 17, 19, 23, 27, 31, 35, 43, 51, 59, 67, 83, 99, 115, 131, 163, 195, 227, 258, 0, 0],
                s = [16, 16, 16, 16, 16, 16, 16, 16, 17, 17, 17, 17, 18, 18, 18, 18, 19, 19, 19, 19, 20, 20, 20, 20, 21, 21, 21, 21, 16, 72, 78],
                a = [1, 2, 3, 4, 5, 7, 9, 13, 17, 25, 33, 49, 65, 97, 129, 193, 257, 385, 513, 769, 1025, 1537, 2049, 3073, 4097, 6145, 8193, 12289, 16385, 24577, 0, 0],
                l = [16, 16, 16, 16, 17, 17, 18, 18, 19, 19, 20, 20, 21, 21, 22, 22, 23, 23, 24, 24, 25, 25, 26, 26, 27, 27, 28, 28, 29, 29, 64, 64];
            e.exports = function(t, e, n, u, c, h, d, f) {
                var p, m, g, v, y, b, _, w, x, k = f.bits,
                    C = 0,
                    E = 0,
                    T = 0,
                    S = 0,
                    A = 0,
                    N = 0,
                    D = 0,
                    O = 0,
                    I = 0,
                    z = 0,
                    L = null,
                    $ = 0,
                    R = new i.Buf16(16),
                    P = new i.Buf16(16),
                    M = null,
                    j = 0;
                for (C = 0; C <= r; C++) R[C] = 0;
                for (E = 0; E < u; E++) R[e[n + E]]++;
                for (A = k, S = r; S >= 1 && 0 === R[S]; S--);
                if (A > S && (A = S), 0 === S) return c[h++] = 20971520, c[h++] = 20971520, f.bits = 1, 0;
                for (T = 1; T < S && 0 === R[T]; T++);
                for (A < T && (A = T), O = 1, C = 1; C <= r; C++)
                    if (O <<= 1, (O -= R[C]) < 0) return -1;
                if (O > 0 && (0 === t || 1 !== S)) return -1;
                for (P[1] = 0, C = 1; C < r; C++) P[C + 1] = P[C] + R[C];
                for (E = 0; E < u; E++) 0 !== e[n + E] && (d[P[e[n + E]]++] = E);
                if (0 === t ? (L = M = d, b = 19) : 1 === t ? (L = o, $ -= 257, M = s, j -= 257, b = 256) : (L = a, M = l, b = -1), z = 0, E = 0, C = T, y = h, N = A, D = 0, g = -1, I = 1 << A, v = I - 1, 1 === t && I > 852 || 2 === t && I > 592) return 1;
                for (var F = 0;;) {
                    F++, _ = C - D, d[E] < b ? (w = 0, x = d[E]) : d[E] > b ? (w = M[j + d[E]], x = L[$ + d[E]]) : (w = 96, x = 0), p = 1 << C - D, m = 1 << N, T = m;
                    do {
                        m -= p, c[y + (z >> D) + m] = _ << 24 | w << 16 | x | 0
                    } while (0 !== m);
                    for (p = 1 << C - 1; z & p;) p >>= 1;
                    if (0 !== p ? (z &= p - 1, z += p) : z = 0, E++, 0 == --R[C]) {
                        if (C === S) break;
                        C = e[n + d[E]]
                    }
                    if (C > A && (z & v) !== g) {
                        for (0 === D && (D = A), y += T, N = C - D, O = 1 << N; N + D < S && !((O -= R[N + D]) <= 0);) N++, O <<= 1;
                        if (I += 1 << N, 1 === t && I > 852 || 2 === t && I > 592) return 1;
                        g = z & v, c[g] = A << 24 | N << 16 | y - h | 0
                    }
                }
                return 0 !== z && (c[y + z] = C - D << 24 | 64 << 16 | 0), f.bits = A, 0
            }
        }, {
            "../utils/common": 62
        }],
        72: [function(t, e, n) {
            "use strict";
            e.exports = {
                2: "need dictionary",
                1: "stream end",
                0: "",
                "-1": "file error",
                "-2": "stream error",
                "-3": "data error",
                "-4": "insufficient memory",
                "-5": "buffer error",
                "-6": "incompatible version"
            }
        }, {}],
        73: [function(t, e, n) {
            "use strict";

            function i(t) {
                for (var e = t.length; --e >= 0;) t[e] = 0
            }

            function r(t, e, n, i, r) {
                this.static_tree = t, this.extra_bits = e, this.extra_base = n, this.elems = i, this.max_length = r, this.has_stree = t && t.length
            }

            function o(t, e) {
                this.dyn_tree = t, this.max_code = 0, this.stat_desc = e
            }

            function s(t) {
                return t < 256 ? ot[t] : ot[256 + (t >>> 7)]
            }

            function a(t, e) {
                t.pending_buf[t.pending++] = 255 & e, t.pending_buf[t.pending++] = e >>> 8 & 255
            }

            function l(t, e, n) {
                t.bi_valid > Z - n ? (t.bi_buf |= e << t.bi_valid & 65535, a(t, t.bi_buf), t.bi_buf = e >> Z - t.bi_valid, t.bi_valid += n - Z) : (t.bi_buf |= e << t.bi_valid & 65535, t.bi_valid += n)
            }

            function u(t, e, n) {
                l(t, n[2 * e], n[2 * e + 1])
            }

            function c(t, e) {
                var n = 0;
                do {
                    n |= 1 & t, t >>>= 1, n <<= 1
                } while (--e > 0);
                return n >>> 1
            }

            function h(t) {
                16 === t.bi_valid ? (a(t, t.bi_buf), t.bi_buf = 0, t.bi_valid = 0) : t.bi_valid >= 8 && (t.pending_buf[t.pending++] = 255 & t.bi_buf, t.bi_buf >>= 8, t.bi_valid -= 8)
            }

            function d(t, e) {
                var n, i, r, o, s, a, l = e.dyn_tree,
                    u = e.max_code,
                    c = e.stat_desc.static_tree,
                    h = e.stat_desc.has_stree,
                    d = e.stat_desc.extra_bits,
                    f = e.stat_desc.extra_base,
                    p = e.stat_desc.max_length,
                    m = 0;
                for (o = 0; o <= V; o++) t.bl_count[o] = 0;
                for (l[2 * t.heap[t.heap_max] + 1] = 0, n = t.heap_max + 1; n < q; n++) i = t.heap[n], o = l[2 * l[2 * i + 1] + 1] + 1, o > p && (o = p, m++), l[2 * i + 1] = o, i > u || (t.bl_count[o]++, s = 0, i >= f && (s = d[i - f]), a = l[2 * i], t.opt_len += a * (o + s), h && (t.static_len += a * (c[2 * i + 1] + s)));
                if (0 !== m) {
                    do {
                        for (o = p - 1; 0 === t.bl_count[o];) o--;
                        t.bl_count[o]--, t.bl_count[o + 1] += 2, t.bl_count[p]--, m -= 2
                    } while (m > 0);
                    for (o = p; 0 !== o; o--)
                        for (i = t.bl_count[o]; 0 !== i;)(r = t.heap[--n]) > u || (l[2 * r + 1] !== o && (t.opt_len += (o - l[2 * r + 1]) * l[2 * r], l[2 * r + 1] = o), i--)
                }
            }

            function f(t, e, n) {
                var i, r, o = new Array(V + 1),
                    s = 0;
                for (i = 1; i <= V; i++) o[i] = s = s + n[i - 1] << 1;
                for (r = 0; r <= e; r++) {
                    var a = t[2 * r + 1];
                    0 !== a && (t[2 * r] = c(o[a]++, a))
                }
            }

            function p() {
                var t, e, n, i, o, s = new Array(V + 1);
                for (n = 0, i = 0; i < F - 1; i++)
                    for (at[i] = n, t = 0; t < 1 << J[i]; t++) st[n++] = i;
                for (st[n - 1] = i, o = 0, i = 0; i < 16; i++)
                    for (lt[i] = o, t = 0; t < 1 << tt[i]; t++) ot[o++] = i;
                for (o >>= 7; i < W; i++)
                    for (lt[i] = o << 7, t = 0; t < 1 << tt[i] - 7; t++) ot[256 + o++] = i;
                for (e = 0; e <= V; e++) s[e] = 0;
                for (t = 0; t <= 143;) it[2 * t + 1] = 8, t++, s[8]++;
                for (; t <= 255;) it[2 * t + 1] = 9, t++, s[9]++;
                for (; t <= 279;) it[2 * t + 1] = 7, t++, s[7]++;
                for (; t <= 287;) it[2 * t + 1] = 8, t++, s[8]++;
                for (f(it, H + 1, s), t = 0; t < W; t++) rt[2 * t + 1] = 5, rt[2 * t] = c(t, 5);
                ut = new r(it, J, B + 1, H, V), ct = new r(rt, tt, 0, W, V), ht = new r(new Array(0), et, 0, U, X)
            }

            function m(t) {
                var e;
                for (e = 0; e < H; e++) t.dyn_ltree[2 * e] = 0;
                for (e = 0; e < W; e++) t.dyn_dtree[2 * e] = 0;
                for (e = 0; e < U; e++) t.bl_tree[2 * e] = 0;
                t.dyn_ltree[2 * G] = 1, t.opt_len = t.static_len = 0, t.last_lit = t.matches = 0
            }

            function g(t) {
                t.bi_valid > 8 ? a(t, t.bi_buf) : t.bi_valid > 0 && (t.pending_buf[t.pending++] = t.bi_buf), t.bi_buf = 0, t.bi_valid = 0
            }

            function v(t, e, n, i) {
                g(t), i && (a(t, n), a(t, ~n)), I.arraySet(t.pending_buf, t.window, e, n, t.pending), t.pending += n
            }

            function y(t, e, n, i) {
                var r = 2 * e,
                    o = 2 * n;
                return t[r] < t[o] || t[r] === t[o] && i[e] <= i[n]
            }

            function b(t, e, n) {
                for (var i = t.heap[n], r = n << 1; r <= t.heap_len && (r < t.heap_len && y(e, t.heap[r + 1], t.heap[r], t.depth) && r++, !y(e, i, t.heap[r], t.depth));) t.heap[n] = t.heap[r], n = r, r <<= 1;
                t.heap[n] = i
            }

            function _(t, e, n) {
                var i, r, o, a, c = 0;
                if (0 !== t.last_lit)
                    do {
                        i = t.pending_buf[t.d_buf + 2 * c] << 8 | t.pending_buf[t.d_buf + 2 * c + 1], r = t.pending_buf[t.l_buf + c], c++, 0 === i ? u(t, r, e) : (o = st[r], u(t, o + B + 1, e), a = J[o], 0 !== a && (r -= at[o], l(t, r, a)), i--, o = s(i), u(t, o, n), 0 !== (a = tt[o]) && (i -= lt[o], l(t, i, a)))
                    } while (c < t.last_lit);
                u(t, G, e)
            }

            function w(t, e) {
                var n, i, r, o = e.dyn_tree,
                    s = e.stat_desc.static_tree,
                    a = e.stat_desc.has_stree,
                    l = e.stat_desc.elems,
                    u = -1;
                for (t.heap_len = 0, t.heap_max = q, n = 0; n < l; n++) 0 !== o[2 * n] ? (t.heap[++t.heap_len] = u = n, t.depth[n] = 0) : o[2 * n + 1] = 0;
                for (; t.heap_len < 2;) r = t.heap[++t.heap_len] = u < 2 ? ++u : 0, o[2 * r] = 1, t.depth[r] = 0, t.opt_len--, a && (t.static_len -= s[2 * r + 1]);
                for (e.max_code = u, n = t.heap_len >> 1; n >= 1; n--) b(t, o, n);
                r = l;
                do {
                    n = t.heap[1], t.heap[1] = t.heap[t.heap_len--], b(t, o, 1), i = t.heap[1], t.heap[--t.heap_max] = n, t.heap[--t.heap_max] = i, o[2 * r] = o[2 * n] + o[2 * i], t.depth[r] = (t.depth[n] >= t.depth[i] ? t.depth[n] : t.depth[i]) + 1, o[2 * n + 1] = o[2 * i + 1] = r, t.heap[1] = r++, b(t, o, 1)
                } while (t.heap_len >= 2);
                t.heap[--t.heap_max] = t.heap[1], d(t, e), f(o, u, t.bl_count)
            }

            function x(t, e, n) {
                var i, r, o = -1,
                    s = e[1],
                    a = 0,
                    l = 7,
                    u = 4;
                for (0 === s && (l = 138, u = 3), e[2 * (n + 1) + 1] = 65535, i = 0; i <= n; i++) r = s, s = e[2 * (i + 1) + 1], ++a < l && r === s || (a < u ? t.bl_tree[2 * r] += a : 0 !== r ? (r !== o && t.bl_tree[2 * r]++, t.bl_tree[2 * K]++) : a <= 10 ? t.bl_tree[2 * Q]++ : t.bl_tree[2 * Y]++, a = 0, o = r, 0 === s ? (l = 138, u = 3) : r === s ? (l = 6, u = 3) : (l = 7, u = 4))
            }

            function k(t, e, n) {
                var i, r, o = -1,
                    s = e[1],
                    a = 0,
                    c = 7,
                    h = 4;
                for (0 === s && (c = 138, h = 3), i = 0; i <= n; i++)
                    if (r = s, s = e[2 * (i + 1) + 1], !(++a < c && r === s)) {
                        if (a < h)
                            do {
                                u(t, r, t.bl_tree)
                            } while (0 != --a);
                        else 0 !== r ? (r !== o && (u(t, r, t.bl_tree), a--), u(t, K, t.bl_tree), l(t, a - 3, 2)) : a <= 10 ? (u(t, Q, t.bl_tree), l(t, a - 3, 3)) : (u(t, Y, t.bl_tree), l(t, a - 11, 7));
                        a = 0, o = r, 0 === s ? (c = 138, h = 3) : r === s ? (c = 6, h = 3) : (c = 7, h = 4)
                    }
            }

            function C(t) {
                var e;
                for (x(t, t.dyn_ltree, t.l_desc.max_code), x(t, t.dyn_dtree, t.d_desc.max_code), w(t, t.bl_desc), e = U - 1; e >= 3 && 0 === t.bl_tree[2 * nt[e] + 1]; e--);
                return t.opt_len += 3 * (e + 1) + 5 + 5 + 4, e
            }

            function E(t, e, n, i) {
                var r;
                for (l(t, e - 257, 5), l(t, n - 1, 5), l(t, i - 4, 4), r = 0; r < i; r++) l(t, t.bl_tree[2 * nt[r] + 1], 3);
                k(t, t.dyn_ltree, e - 1), k(t, t.dyn_dtree, n - 1)
            }

            function T(t) {
                var e, n = 4093624447;
                for (e = 0; e <= 31; e++, n >>>= 1)
                    if (1 & n && 0 !== t.dyn_ltree[2 * e]) return L;
                if (0 !== t.dyn_ltree[18] || 0 !== t.dyn_ltree[20] || 0 !== t.dyn_ltree[26]) return $;
                for (e = 32; e < B; e++)
                    if (0 !== t.dyn_ltree[2 * e]) return $;
                return L
            }

            function S(t) {
                dt || (p(), dt = !0), t.l_desc = new o(t.dyn_ltree, ut), t.d_desc = new o(t.dyn_dtree, ct), t.bl_desc = new o(t.bl_tree, ht), t.bi_buf = 0, t.bi_valid = 0, m(t)
            }

            function A(t, e, n, i) {
                l(t, (P << 1) + (i ? 1 : 0), 3), v(t, e, n, !0)
            }

            function N(t) {
                l(t, M << 1, 3), u(t, G, it), h(t)
            }

            function D(t, e, n, i) {
                var r, o, s = 0;
                t.level > 0 ? (t.strm.data_type === R && (t.strm.data_type = T(t)), w(t, t.l_desc),
                    w(t, t.d_desc), s = C(t), r = t.opt_len + 3 + 7 >>> 3, (o = t.static_len + 3 + 7 >>> 3) <= r && (r = o)) : r = o = n + 5, n + 4 <= r && -1 !== e ? A(t, e, n, i) : t.strategy === z || o === r ? (l(t, (M << 1) + (i ? 1 : 0), 3), _(t, it, rt)) : (l(t, (j << 1) + (i ? 1 : 0), 3), E(t, t.l_desc.max_code + 1, t.d_desc.max_code + 1, s + 1), _(t, t.dyn_ltree, t.dyn_dtree)), m(t), i && g(t)
            }

            function O(t, e, n) {
                return t.pending_buf[t.d_buf + 2 * t.last_lit] = e >>> 8 & 255, t.pending_buf[t.d_buf + 2 * t.last_lit + 1] = 255 & e, t.pending_buf[t.l_buf + t.last_lit] = 255 & n, t.last_lit++, 0 === e ? t.dyn_ltree[2 * n]++ : (t.matches++, e--, t.dyn_ltree[2 * (st[n] + B + 1)]++, t.dyn_dtree[2 * s(e)]++), t.last_lit === t.lit_bufsize - 1
            }
            var I = t("../utils/common"),
                z = 4,
                L = 0,
                $ = 1,
                R = 2,
                P = 0,
                M = 1,
                j = 2,
                F = 29,
                B = 256,
                H = B + 1 + F,
                W = 30,
                U = 19,
                q = 2 * H + 1,
                V = 15,
                Z = 16,
                X = 7,
                G = 256,
                K = 16,
                Q = 17,
                Y = 18,
                J = [0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 0],
                tt = [0, 0, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10, 11, 11, 12, 12, 13, 13],
                et = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 3, 7],
                nt = [16, 17, 18, 0, 8, 7, 9, 6, 10, 5, 11, 4, 12, 3, 13, 2, 14, 1, 15],
                it = new Array(2 * (H + 2));
            i(it);
            var rt = new Array(2 * W);
            i(rt);
            var ot = new Array(512);
            i(ot);
            var st = new Array(256);
            i(st);
            var at = new Array(F);
            i(at);
            var lt = new Array(W);
            i(lt);
            var ut, ct, ht, dt = !1;
            n._tr_init = S, n._tr_stored_block = A, n._tr_flush_block = D, n._tr_tally = O, n._tr_align = N
        }, {
            "../utils/common": 62
        }],
        74: [function(t, e, n) {
            "use strict";

            function i() {
                this.input = null, this.next_in = 0, this.avail_in = 0, this.total_in = 0, this.output = null, this.next_out = 0, this.avail_out = 0, this.total_out = 0, this.msg = "", this.state = null, this.data_type = 2, this.adler = 0
            }
            e.exports = i
        }, {}]
    }, {}, [10])(10)
}),
function(t) {
    "object" == typeof exports ? module.exports = t() : "function" == typeof define && define.amd ? define(t) : "undefined" != typeof window ? window.JSZipUtils = t() : "undefined" != typeof global ? global.JSZipUtils = t() : "undefined" != typeof self && (self.JSZipUtils = t())
}(function() {
    return function t(e, n, i) {
        function r(s, a) {
            if (!n[s]) {
                if (!e[s]) {
                    var l = "function" == typeof require && require;
                    if (!a && l) return l(s, !0);
                    if (o) return o(s, !0);
                    throw new Error("Cannot find module '" + s + "'")
                }
                var u = n[s] = {
                    exports: {}
                };
                e[s][0].call(u.exports, function(t) {
                    var n = e[s][1][t];
                    return r(n || t)
                }, u, u.exports, t, e, n, i)
            }
            return n[s].exports
        }
        for (var o = "function" == typeof require && require, s = 0; s < i.length; s++) r(i[s]);
        return r
    }({
        1: [function(t, e, n) {
            "use strict";

            function i() {
                try {
                    return new window.XMLHttpRequest
                } catch (t) {}
            }

            function r() {
                try {
                    return new window.ActiveXObject("Microsoft.XMLHTTP")
                } catch (t) {}
            }
            var o = {};
            o._getBinaryFromXHR = function(t) {
                return t.response || t.responseText
            };
            var s = window.ActiveXObject ? function() {
                return i() || r()
            } : i;
            o.getBinaryContent = function(t, e) {
                try {
                    var n = s();
                    n.open("GET", t, !0), console.log("path", t), "responseType" in n && (n.responseType = "arraybuffer"), n.overrideMimeType && n.overrideMimeType("text/plain; charset=x-user-defined"), n.onreadystatechange = function(i) {
                        var r, s;
                        if (4 === n.readyState)
                            if (200 === n.status || 0 === n.status) {
                                r = null, s = null;
                                try {
                                    r = o._getBinaryFromXHR(n), console.log("getBinaryContent arrayBuffer", r, " bytes:", r.byteLength.toLocaleString())
                                } catch (t) {
                                    s = new Error(t)
                                }
                                e(s, r)
                            } else e(new Error("Ajax error for " + t + " : " + this.status + " " + this.statusText), null)
                    }, n.onprogress = function(t) {
                        t.lengthComputable && setCirclebar(t)
                    }, n.send()
                } catch (t) {
                    e(new Error(t), null)
                }
            }, e.exports = o
        }, {}]
    }, {}, [1])(1)
}), $(document).ready(function() {
    function t() {
        var t = c.offsetWidth,
            e = c.offsetHeight;
        !0 === $("#editarea").is(".full-screen") && (t = window.innerWidth, e = window.innerHeight), d.aspect = t / e, d.updateProjectionMatrix(), m.setSize(t, e), g.handleResize()
    }

    function e() {
        requestAnimationFrame(e), g.update(), n(), h && h.update()
    }

    function n() {
        Date.now();
        m.render(p, d)
    }

    function i(t) {
        t.traverse(function(t) {
            t instanceof THREE.Mesh ? (console.log("dispose geom"), t.geometry && t.geometry.dispose(), t.material && (t.material instanceof THREE.MeshFaceMaterial || t.material instanceof THREE.MultiMaterial ? t.material.materials.forEach(function(t, e) {
                t.map && t.map.dispose(), t.lightMap && t.lightMap.dispose(), t.bumpMap && t.bumpMap.dispose(), t.normalMap && t.normalMap.dispose(), t.specularMap && t.specularMap.dispose(), t.envMap && t.envMap.dispose(), t.dispose()
            }) : (t.material.map && t.material.map.dispose(), t.material.lightMap && t.material.lightMap.dispose(), t.material.bumpMap && t.material.bumpMap.dispose(), t.material.normalMap && t.material.normalMap.dispose(), t.material.specularMap && t.material.specularMap.dispose(), t.material.envMap && t.material.envMap.dispose(), t.material.dispose()))) : t instanceof THREE.Sprite && (console.log("dispose sprite"), t.material && (t.material.map && t.material.map.dispose(), t.material.dispose()), t.geometry && t.geometry.dispose())
        })
    }

    function r(t) {
        function e(t) {
            return "p3d" == t || "p2dfmt" == t || "p3dfmt" == t ? l = new THREE.Plot3DLoader : "stl" == t ? l = new THREE.STLLoader : "msh" == t ? l = new THREE.MSHLoader : "wrl" == t && (l = new THREE.VRMLLoader), l
        }
        $("#mesh-title").text(t);
        var n = p.getObjectByName("loaded-mesh");
        n && (i(n), p.remove(n)), $("#circle-bar").show();
        var r = function(t) {
                t.name = "loaded-mesh", t.traverse(function(t) {
                    t instanceof THREE.Mesh && t.material instanceof THREE.MeshPhongMaterial && console.log("phong")
                });
                var e = (new THREE.Box3).setFromObject(t),
                    n = e.getSize(),
                    i = e.getCenter(),
                    r = i.clone(),
                    o = Math.max(n.x, n.y, n.z);
                v = o, r.z += 2.5 * o, d.position.copy(r), g.target = i, p.add(t);
                var s = "";
                if (l.info) {
                    s += "size: " + l.info.fileSize + "<br/>", s += "blocks: " + l.info.blocks.length + "<br/>";
                    for (var a = 0; a < l.info.blocks.length; ++a) {
                        var u = l.info.blocks[a];
                        s += "\tblock[" + a + "]: " + u.width + "x" + u.height + "x" + u.depth + "<br/>"
                    }
                } else s += "size: 0<br/>", s += "blocks: 0<br/>";
                $("#mesh-info").html(s), $("#circle-bar").hide()
            },
            o = function(t) {
                if (t.lengthComputable) {
                    var e = t.loaded / t.total * 100;
                    console.log(Math.round(e, 2) + "% downloaded"), $("#mesh-progress").text(Math.round(e, 2) + "%"), setCirclebar(t)
                }
            },
            s = function(t) {},
            a = t.substring(t.lastIndexOf(".") + 1),
            l = e(a);
        if ("zip" == a) {
            var u = t.substr(0, t.lastIndexOf("."));
            u = u.substr(u.lastIndexOf("/") + 1).toLowerCase(), a = u.substring(u.lastIndexOf(".") + 1), l = e(a), JSZipUtils.getBinaryContent(t, function(t, e) {
                if (t) return void console.log("zip request err: ", t);
                try {
                    JSZip.loadAsync(e).then(function(t) {
                        console.log("archive ZIP loaded");
                        var e = {};
                        for (f in t.files) {
                            e[f.substr(f.lastIndexOf("/") + 1).toLowerCase()] = t.files[f]
                        }
                        t.files = e, console.log("filename", u);
                        var n = t.file(u);
                        if (!n) return void console.log("zip.file:" + u + " not found");
                        console.log("opening zip entry"), console.time("opening zip entry"), n.async("arraybuffer").then(function(t) {
                            console.timeEnd("opening zip entry");
                            var e = t;
                            r(l.parse(e))
                        })
                    }, function(t) {
                        console.error("zip load error:", t)
                    })
                } catch (t) {
                    console.error("zip load error:", t)
                }
            })
        } else l.load(t, r, o, s)
    }

    function o() {
        $(".mesh-select").change(function() {
            var t = this.options[this.selectedIndex].value;
            console.log(t), $("#mesh-progress").html(""), $("#mesh-title").html(""), $("#mesh-info").html(""), r("/data/" + t), w.points = !0, w.lines = !0, w.surfaces = !0, $(".visibility-enable[data-type=points]")[0].checked = w.points, $(".visibility-enable[data-type=lines]")[0].checked = w.lines, $(".visibility-enable[data-type=surfaces]")[0].checked = w.surfaces, m.clippingPlanes = _, y.x.constant = 0, y.y.constant = 0, y.z.constant = 0, b.x = !1, b.y = !1, b.z = !1, $(".clip-enable").each(function(t) {
                this.checked = !1
            }), $(".clip-slider").slider("disable")
        }), $(".full-screen").click(function() {
            THREEx.FullScreen.activated() ? THREEx.FullScreen.cancel() : THREEx.FullScreen.request($("#editarea")[0])
        }), $(".general-controls .control.help").on("click", function() {
            $(".overlay.help").removeClass("hiddenOverlay")
        }), $(".general-controls .control.settings").on("click", function(t) {
            s()
        }), $("#container").on("mousedown touchstart", function(t) {
            !1 === $.contains($(".control-menu.settings-menu")[0], t.target) && $(".general-controls .control.settings").removeClass("active")
        }), $(".control-menu-list .setting").click(function() {
            var t, e = $(this).attr("data-setting"),
                n = $(this).find(".setting-value").attr("data-value");
            $(".control-menu.settings-menu").is(".detail") || $(".control-menu.settings-menu").addClass("detail"), "shadingStyle" === e ? t = '<div class="setting-list-header">       <a class="back control-menu-back">Back</a>       <span class="setting-list-header-help">Key</span>   </div>    <ul class="setting-list" data-setting="shadingStyle">        <li class="setting-item" data-value="defaultmat">Default<span class="shortcut" title="Keyboard shortcut"><kbd>1</kbd></span></li><li class="setting-item " data-value="shadeless">Shadeless<span class="shortcut" title="Keyboard shortcut"><kbd>2</kbd></span></li><li class="setting-item " data-value="matcap">MatCap<span class="shortcut" title="Keyboard shortcut"><kbd>3</kbd></span></li>  <li class="setting-item " data-value="demo">Demo Mode<span class="shortcut" title="Keyboard shortcut"><kbd>4</kbd></span></li>  </ul>    <p class="wireframe-title wireframe-setting-group">Wireframe <span class="shortcut" title="Keyboard shortcut"><kbd>5</kbd></span></p>    <div class="wireframe-colors wireframe-setting-group">        <a class="colors-none active" data-setting="wireframeEnable" data-value="0" title="Off"></a><!--        --><a class="colors-black" data-setting="wireframeColor" data-value="000000" title="Black"></a><!--        --><a class="colors-white" data-setting="wireframeColor" data-value="ffffff" title="White"></a><!--        --><a class="colors-red" data-setting="wireframeColor" data-value="ff507f" title="Red"></a><!--        --><a class="colors-blue" data-setting="wireframeColor" data-value="4d9cff" title="Blue"></a><!--        --><a class="colors-green" data-setting="wireframeColor" data-value="2d9e84" title="Green"></a><!--        --><a class="colors-yellow" data-setting="wireframeColor" data-value="ebc712" title="Yellow"></a>    </div>' : "annotationsVisible" === e ? t = '<a class="control-menu-back back">Back</a>   <ul class="setting-list" data-setting="annotationsVisible" data-setting-type="bool">       <li class="setting-item" data-value="true">Visible<span class="shortcut" title="Keyboard shortcut"></span></li><li class="setting-item " data-value="false">Hidden<span class="shortcut" title="Keyboard shortcut"></span></li>   </ul>' : "viewpointsVisible" === e ? t = '<a class="control-menu-back back">Back</a>   <ul class="setting-list" data-setting="viewpointsVisible" data-setting-type="bool">       <li class="setting-item" data-value="true">Visible<span class="shortcut" title="Keyboard shortcut"></span></li><li class="setting-item " data-value="false">Hidden<span class="shortcut" title="Keyboard shortcut"></span></li>   </ul>' : "cycleMode" === e || "speed" === e || ("viewerMode" === e ? t = document.location.href.indexOf("3dcrafts.net") > -1 && !1 === CTX.mobileCheck() ? '<a class="control-menu-back back">Back</a>   <ul class="setting-list" data-setting="viewerMode" data-setting-type="string">       <li class="setting-item" data-value="0">Orbit<span class="shortcut" title="Keyboard shortcut"></span></li><li class="setting-item " data-value="1">First Person<span class="shortcut" title="Keyboard shortcut"></span></li>   </ul>' : '<a class="control-menu-back back">Back</a>   <ul class="setting-list" data-setting="viewerMode" data-setting-type="string">       <li class="setting-item" data-value="0">Orbit<span class="shortcut" title="Keyboard shortcut"></span></li><li class="setting-item " data-value="1">First Person<span class="shortcut" title="Keyboard shortcut"></span></li><li class="setting-item " data-value="2">Gyroscope<span class="shortcut" title="Keyboard shortcut"></span></li>  </ul>' : "textureQuality" === e && (t = '<a class="control-menu-back back">Back</a>   <ul class="setting-list" data-setting="textureQuality" data-setting-type="string">       <li class="setting-item " data-value="0">LD<span class="shortcut" title="Keyboard shortcut"></span></li><li class="setting-item selected" data-value="1">HD<span class="shortcut" title="Keyboard shortcut"></span></li>   </ul>')), $(".control-menu-pane").append(t), $("[data-setting=" + e + "] .setting-item[data-value=" + n + "]").addClass("selected")
        }), $("body").on("click", ".control-menu-back", function() {
            $(".control-menu.settings-menu").removeClass("detail"), $(".control-menu-pane").html("")
        }), $("body").on("click", ".settings-menu.detail .setting-item", function() {
            var t = CTX.annotationGroup,
                e = CTX.viewpointGroup,
                n = $(this).closest(".setting-list").attr("data-setting"),
                i = $(this).attr("data-value"),
                r = $(this).clone().children().remove().end().text();
            if ("shadingStyle" === n) {
                if ("defaultmat" === $(this).attr("data-value")) CTX.setRenderMode("defaultmat"), CTX.demoMode = "none";
                else if ("shadeless" === $(this).attr("data-value")) CTX.setRenderMode("shadeless"), CTX.demoMode = "none";
                else if ("matcap" === $(this).attr("data-value")) CTX.setRenderMode("matcap"), CTX.demoMode = "none";
                else if ("demo" === $(this).attr("data-value")) {
                    CTX.model;
                    CTX.demoMode = "defaultmat", CTX.demoTime = CTX.demoDuration;
                    var o = CTX.wireframeModel;
                    o.visible = !1
                }
            } else "annotationsVisible" === n ? "true" === $(this).attr("data-value") ? t.visible = !0 : t.visible = !1 : "viewpointsVisible" === n ? "true" === $(this).attr("data-value") ? e.visible = !0 : e.visible = !1 : "cycleMode" === n || "speed" === n || "viewerMode" === n && ("0" === $(this).attr("data-value") ? CTX.setControlMode("orbit") : "1" === $(this).attr("data-value") ? CTX.setControlMode("first") : "2" === $(this).attr("data-value") && CTX.setControlMode("device"));
            $(this).closest(".detail").removeClass("detail"), $(".control-menu-pane").html(""), $("[data-setting=" + n + "] .setting-value").attr("data-value", i), $("[data-setting=" + n + "] .setting-value").text(r)
        }), $("body").on("click", ".wireframe-colors a", function() {
            $(".wireframe-colors a").each(function() {
                $(this).removeClass("active")
            }), $(this).addClass("active"), "wireframeColor" === $(this).attr("data-setting") ? CTX.setRenderMode("wireframe", "#" + $(this).attr("data-value")) : CTX.setRenderMode("wireframe")
        })
    }

    function s() {
        $("#sidebar").is(":visible") ? (u = "view", $(".navbar.navbar-fixed-top").hide(), $("#sidebar").hide(), $("#editarea").css({
            width: "100%"
        })) : (u = "edit", $(".navbar.navbar-fixed-top").show(), $("#sidebar").show(), $("#editarea").css({
            width: "calc(100% - 300px)"
        })), t()
    }
    if ($("#circle-bar").show(), circle = new ProgressBar.Circle("#circle-bar", {
            color: "#F2CB61",
            strokeWidth: 10,
            trailWidth: 3,
            duration: 100
        }), circle.setText("0%"), URLSearchParams) {
        var a = new URLSearchParams(window.location.search.slice(1));
        if (a) var l = a.get("url")
    }
    var u;
    l ? (u = "view", $(".navbar.navbar-fixed-top").hide(), $("#sidebar").hide(), $("#editarea").css({
        width: "100%"
    })) : (u = "edit", $(".navbar.navbar-fixed-top").show(), $("#sidebar").show(), $("#editarea").css({
        width: "calc(100% - 300px)"
    })), console.log("viewer mode", u), Detector.webgl || Detector.addGetWebGLMessage();
    var c, h, d, p, m, g, v, y = (new THREE.Plane(new THREE.Vector3(0, -1, 0), .8), {
            x: new THREE.Plane(new THREE.Vector3(-1, 0, 0), .1),
            y: new THREE.Plane(new THREE.Vector3(0, -1, 0), .1),
            z: new THREE.Plane(new THREE.Vector3(0, 0, -1), .1)
        }),
        b = {
            x: !1,
            y: !1,
            z: !1
        },
        _ = Object.freeze([]),
        w = {
            points: !0,
            lines: !0,
            surfaces: !0
        };
    ! function() {
        c = document.getElementById("container");
        var e = c.offsetWidth,
            i = c.offsetHeight;
        d = new THREE.PerspectiveCamera(27, e / i, .1, 4e4), d.position.z = 3e3, g = new THREE.TrackballControls(d, c), g.rotateSpeed = 15, g.zoomSpeed = 1.2, g.panSpeed = .8, g.noZoom = !1, g.noPan = !1, g.keys = [65, 83, 68], g.addEventListener("change", n), p = new THREE.Scene;
        var s = new THREE.DirectionalLight(16777215, 1);
        s.position.set(1, 1, 1), d.add(s), p.add(d), m = new THREE.WebGLRenderer({
            antialias: !1
        }), m.setPixelRatio(window.devicePixelRatio), m.setSize(e, i), m.setClearColor(new THREE.Color(.8, .8, 1, 0)), m.gammaInput = !0, m.gammaOutput = !0, m.clippingPlanes = _, c.appendChild(m.domElement), "edit" == u && (h = new Stats, c.appendChild(h.dom), h.dom.style.top = "", h.dom.style.bottom = "0px"), window.addEventListener("resize", t, !1), o();
        //var a = "/data/msh/test_block.msh";
        var a = filePath;
        //var a = 'http://localhost:8080/web/guest/view-designer-v2?p_p_auth=9JUAi7M1&p_p_id=sdrcommon_WAR_SDR_baseportlet&p_p_lifecycle=2&p_p_state=exclusive&p_p_mode=view&p_p_resource_id=datasetFilePath&p_p_cacheability=cacheLevelPage&_sdrcommon_WAR_SDR_baseportlet_datasetId=0&_sdrcommon_WAR_SDR_baseportlet_path=/cfd.p3d';
        console.log('filePath',filePath);
        l && (a = l), r(a)
    }(),
    function() {
        var t = function() {
            var t = this.checked,
                e = this.dataset.type;
            w[e] = t, p.getObjectByName("loaded-mesh").traverse(function(t) {
                if (t) {
                    var e = t.material;
                    t instanceof THREE.Mesh ? e instanceof THREE.MeshLambertMaterial && (console.log("mtl found"), t.visible = w.surfaces) : t instanceof THREE.LineSegments ? e instanceof THREE.LineBasicMaterial && (console.log("line mtl found"), t.visible = w.lines) : t instanceof THREE.Points && e instanceof THREE.PointsMaterial && (console.log("points mtl found"), t.visible = w.points)
                }
            })
        };
        $(".visibility-enable").change(t), $(".visibility-enable[data-type=points]")[0].checked = w.points, $(".visibility-enable[data-type=lines]")[0].checked = w.lines, $(".visibility-enable[data-type=surfaces]")[0].checked = w.surfaces;
        var e = function() {
                var t = this.checked,
                    e = this.dataset.axis;
                b[e] = t;
                var n = [];
                for (var i in y) b[i] && n.push(y[i]);
                0 == n.length && (n = _), m.clippingPlanes = n, t ? $(".clip-slider[data-axis=" + e + "]").slider("enable") : $(".clip-slider[data-axis=" + e + "]").slider("disable")
            },
            n = function() {
                var t = Number($(this).val()),
                    e = this.dataset.axis;
                y[e].constant = t * v, console.log(e, t, t * v)
            };
        $(".clip-enable").change(e), $(".clip-slider").on("slide", n).slider({
            tooltip: "always",
            enabled: !1
        }).data("slider")
    }(), e(), window.setCirclebar = function(t) {
        console.log(t.loaded);
        var e = t.currentTarget && t.currentTarget.responseURL || "",
            n = e.substr(e.lastIndexOf("/") + 1),
            i = t.loaded || t.position,
            r = t.total || t.totalSize;
        if (0 === r) return console.error("download total size 0: " + n), void(r = i);
        if (r) {
            var o = i / r;
            circle.setText((100 * o).toFixed(0) + "%"), o >= 1 ? circle.set(o) : circle.animate(o, function() {
                console.log("on anim finish:" + o)
            })
        }
    }
}), window.URLSearchParams = window.URLSearchParams || function(t) {
    var e = [],
        n = {},
        i = function(t) {
            return encodeURIComponent(t).replace(/[!'()*]/g, function(t) {
                return "%" + t.charCodeAt(0).toString(16)
            })
        },
        r = function(t, i) {
            n[t] || (n[t] = []), n[t].push(e.push({
                key: t,
                val: i
            }) - 1)
        };
    return t && t.split("&").forEach(function(t) {
        return r.apply(null, t.split("="))
    }), {
        has: function(t) {
            return !!n[t]
        },
        append: r,
        delete: function(t) {
            n[t] && (e = e.filter(function(e) {
                return e.key !== t
            }), delete n[t])
        },
        get: function(t) {
            return n[t] ? e[n[t][0]].val : null
        },
        getAll: function(t) {
            return n[t] ? n[t].map(function(t) {
                return e[t].val
            }) : []
        },
        set: function(t, i) {
            if (!n[t]) return void r(t, i);
            if (1 === n[t].length) return void(e[n[t][0]].val = i);
            var o = e,
                s = !0;
            e = [], n = {}, o.forEach(function(e) {
                if (e.key !== t) return void r(e.key, e.val);
                s && (r(e.key, i), s = !1)
            })
        },
        toString: function() {
            return e.map(function(t) {
                return t.key + "=" + i(t.val)
            }).join("&")
        }
    }
};
